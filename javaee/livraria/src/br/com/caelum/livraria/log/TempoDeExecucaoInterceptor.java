package br.com.caelum.livraria.log;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.caelum.livraria.bean.Log;

@Log
@Interceptor
public class TempoDeExecucaoInterceptor implements Serializable {

	private static final long serialVersionUID = 3195108295235384392L;

	@AroundInvoke
	public Object executaLog(InvocationContext contexto) throws Exception {

	    Long inicio = System.currentTimeMillis();

	    Object resultado = contexto.proceed();

	    Long fim = System.currentTimeMillis();
	    System.out.println(contexto.getMethod() + " spent: " + (fim - inicio) + "ms" );

	    return resultado;
	}
}