package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(  filterName="setCharacterEncoding",
             urlPatterns={"/*" , "/hello.do" },   //指這些URL請求會套用該濾器         (注意*其實已經涵蓋後者)
             servletNames={"*" , "Hello"},        //指這些Servlet註冊名稱會套用該濾器 (注意*其實已經涵蓋後者)
             initParams = {
                  @WebInitParam(name="encoding",value="UTF-8")
             }
           )
public class SetCharacterEncodingFilter implements Filter {

    protected String encoding = null;
    protected FilterConfig filterConfig = null;
    protected boolean ignore = true;

    @Override
    public void destroy() {

        this.encoding = null;
        this.filterConfig = null;

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
        throws IOException, ServletException {

        if (ignore || (request.getCharacterEncoding() == null)) {
            String characterEncoding = selectEncoding(request);
            if (characterEncoding != null)
                request.setCharacterEncoding(characterEncoding);
        }

        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

        this.filterConfig = fConfig;
        this.encoding = fConfig.getInitParameter("encoding");
        String value = fConfig.getInitParameter("ignore");
        if (value == null)
            this.ignore = true;
        else if (value.equalsIgnoreCase("true"))
            this.ignore = true;
        else if (value.equalsIgnoreCase("yes"))
            this.ignore = true;
        else
            this.ignore = false;

    }

    protected String selectEncoding(ServletRequest request) {

        return (this.encoding);

    }


}
