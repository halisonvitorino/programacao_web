package thread;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thread.Podium;

/**
 * Servlet implementation class Carro
 */
@WebServlet("/Carro")

    public class Carro extends Thread  
    {  
          
        private Podium campeao;  
        private String corredor;     
          
          
    public Carro(String nome, Podium c)  
    {  
        corredor = nome;  
        campeao = c;  
    }  
         
        @Override  
    public void run()  
    {  
              
              
          try  
          {  
                int i;  
                for(i=1;i<15;i++)  
                {  
              
                    System.out.println(i+"º.Curva - Piloto "+ corredor);  
                    int tempo = (int)(Math.random()*300);  
                    sleep(tempo);  
                    
                }     
                System.out.println("Chegada - Piloto "+ corredor);
               this.campeao.setVencedor(corredor); 
              
          }    
          catch(Exception e)  
          {  
                 e.printStackTrace();             
          }  
      }  
 
     
    }
