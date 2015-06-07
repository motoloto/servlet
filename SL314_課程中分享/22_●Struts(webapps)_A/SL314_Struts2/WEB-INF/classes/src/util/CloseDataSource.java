package sl314.web;

// Servlet imports
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
// Support classes
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.Binding;
import javax.naming.NamingException;
// Jakarta Commons DCBP imports
import org.apache.commons.dbcp.BasicDataSource;

/**
 * This servlet context listener shuts down the DataSource (Jakarta Commons DBCP)
 * stored in a JNDI context.
 */
public class CloseDataSource implements ServletContextListener {

  public void contextInitialized(ServletContextEvent event) {
    // The DataSource is initialized by Tomcat
  }

  public void contextDestroyed(ServletContextEvent event) {
    ServletContext sctx = event.getServletContext();

    try {

      // Initialize JNDI
      Context ctx = new InitialContext();
      if ( ctx == null ) {
        sctx.log("JNDI Context could not be found.");
        return;
      }

      // Retrieve the DataSource (Commons DBCP) from JNDI
      BasicDataSource ds
        = (BasicDataSource) ctx.lookup("java:comp/env/jdbc/leagueDB");
      if ( ds == null ) {
        sctx.log("DataSource (java:comp/env/jdbc/leagueDB) could not be found.");
        return;
      }

      // Close the DataSource (this operation does not exist in the interface)
      ds.close();
      sctx.log("DataSource (java:comp/env/jdbc/leagueDB) has been shutdown.");

    } catch (Exception e) {
      sctx.log("An exception occured when trying to shutdown the DataSource.", e);
    }
  }
}
