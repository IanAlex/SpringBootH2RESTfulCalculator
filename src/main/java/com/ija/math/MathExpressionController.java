package com.ija.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/math")
public class MathExpressionController {
	
	@Autowired
	 private MathExpressionService mathExpressionService;
	  
	 public void setMathExpressionService(MathExpressionService mathExpressionService) {
	  this.mathExpressionService = mathExpressionService;
	 }
	 
	
	 @GetMapping("/sum/{xVal}/{yVal}")
	 public MathExpression getASum(@PathVariable(name="xVal") Integer x, @PathVariable(name="yVal") Integer y){
	   return mathExpressionService.getAndWriteASum(x, y);
	 }
	 
	 @GetMapping("/product/{aVal}")
	 public MathExpression getAProduct(@PathVariable(name="aVal") Integer a){
	   return mathExpressionService.getAndWriteAProduct(a);
	 }
	 
	 @GetMapping("/power/{sVal}")
	 public MathExpression getAPower(@PathVariable(name="sVal") Integer s){
	   return mathExpressionService.getAndWriteAPower(s);
	 }

}
