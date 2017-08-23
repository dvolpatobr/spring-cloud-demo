package br.com.volpato.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")
public class TesteController {



	@RequestMapping("/stuff")
	private String  doStuff() {

		return "ssutuff";
	}
	
}
