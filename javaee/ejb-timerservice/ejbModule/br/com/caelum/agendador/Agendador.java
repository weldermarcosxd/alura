package br.com.caelum.agendador;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class Agendador {
	@Schedule(hour="*", minute="*", second="*/10", persistent=false)    
    void agendado() {
        System.out.println("verificando serviço externo periodicamente");
    }
}
