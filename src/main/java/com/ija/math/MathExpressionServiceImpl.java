package com.ija.math;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathExpressionServiceImpl implements MathExpressionService {

	@Autowired
	private MathExpressionRepository mathExpressionRepository;
	
	public void setEmployeeRepository(MathExpressionRepository mathExpressionRepository) {
		  this.mathExpressionRepository = mathExpressionRepository;
	}
	
	@Override
	public MathExpression getAndWriteASum(int x, int y) {
		int sum = x + y;
		MathExpression me = new MathExpression();
		me.setOperationDesc(x + " + " + y);
		me.setResult(sum);
		return mathExpressionRepository.save(me);
	}

	@Override
	public MathExpression getAndWriteAProduct(int a) {
		int product = a * 2;
		MathExpression me = new MathExpression();
		me.setOperationDesc(a + " * 2");
		me.setResult(product);
		return mathExpressionRepository.save(me);
	}

	@Override
	public MathExpression getAndWriteAPower(int s) {
		int squared = s * s;
		MathExpression me = new MathExpression();
		me.setOperationDesc(s + "^2");
		me.setResult(squared);
		return mathExpressionRepository.save(me);
	}

}
