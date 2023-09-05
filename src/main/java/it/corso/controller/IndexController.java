package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

// localhost:8080
@Controller
@RequestMapping("/")
public class IndexController
{
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping
	public String getPage(Model model)
	{
		List<Prodotto> prodotti = prodottoService.getProdotti();
		model.addAttribute("prodotti", prodotti);
		return "index";
	}
	
	@GetMapping("/cancella")
	public String cancellaProdotto(@RequestParam("id") int id)
	{
		prodottoService.cancellaProdotto(id);
		return "redirect:/";
	}
}