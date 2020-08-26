package cl.takeshi;

import java.net.URI;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import cl.takeshi.beans.Comment;
import cl.takeshi.beans.Post;
import cl.takeshi.beans.Publicacion;
import cl.takeshi.dao.DAOcomment;
import cl.takeshi.dao.DAOpost;
import cl.takeshi.dao.DAOpublicaciones;


@Controller
public class HomeController {
	
	@Autowired
	DAOpost postDAO;
	
	@Autowired
	DAOcomment commentDAO;
	
	@Autowired
	DAOpublicaciones publicacionesDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView listadoReservas(HttpServletRequest request, ModelMap model) {
		System.out.println("--->>PUBLICACIONES");
		
		model.addAttribute("publicaciones", publicacionesDAO.listarTodos());
			
		return new ModelAndView("publicaciones", "model", model);
		}
	
	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView comentarios(@PathVariable int id,HttpServletRequest request, ModelMap model) {
		System.out.println("--->>COMENTARIOS");
		
		List<Publicacion> listapub = publicacionesDAO.listarById(id);
		model.addAttribute("titulo", listapub.get(0).getTitle());
		
		
		List<Comment> comentarios = commentDAO.listarcomentarios(id);
		for (Comment comment : comentarios) {
			String txt = comment.getBody().substring(0,19);
			comment.setVeinte(txt);
		}
		
		model.addAttribute("comentarios", comentarios);
		
		return new ModelAndView("comentarios", "model", model);
	}

	
	
	
	
	
	@RequestMapping(value="/carga", method = RequestMethod.GET)
	public ModelAndView alumnosByIdJsp(HttpServletRequest request, ModelMap model) {
		System.out.println("CARGANDO DATOS.......");
		
		commentDAO.borrarComentarios();
		postDAO.borrarPosts();
				
		final String uriPosts = "https://jsonplaceholder.typicode.com/posts";
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<List<Post>> postResponse = restTemplate.exchange(uriPosts, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {});
		List<Post> listaPosts = postResponse.getBody();
		for (Post post : listaPosts) {
			System.out.println("Post "+post.getId()+" " + post.getTitle());
			try {
				postDAO.ingresarPost(post);
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
			
		final String uriComments = "https://jsonplaceholder.typicode.com/comments";
		ResponseEntity<List<Comment>> postResponse2 = restTemplate.exchange(uriComments, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {});
		List<Comment> listaComments = postResponse2.getBody();
		for (Comment comment : listaComments) {
			System.out.println("Comentario "+ comment.getId()+ " "+ comment.getEmail());
			try {
				commentDAO.ingresarComentario(comment);
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
		return new ModelAndView("redirect:/");
	}
	
	
	
}
