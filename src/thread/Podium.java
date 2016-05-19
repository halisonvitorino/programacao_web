package thread;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Podium
 */
@WebServlet("/Podium")
public class Podium  
{  
      
    private String vencedor;  
    private boolean fim = false;  
  
    public void setVencedor(String vencedor)  
    {  
          
        if(fim == false)  
        {  
             this.vencedor = vencedor;  
             fim  = true;  
        }  
    }       
        
      
    public String getVencedor()  
    {  
        return vencedor;  
    }  
  

}
