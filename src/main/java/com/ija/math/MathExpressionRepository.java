package com.ija.math;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathExpressionRepository extends JpaRepository<MathExpression, Long> {

}
