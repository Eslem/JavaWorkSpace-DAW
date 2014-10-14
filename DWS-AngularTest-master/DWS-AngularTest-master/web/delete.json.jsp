<%@page import="com.alzatezabala.fp.persistencia.EntidadBancariaDAOImplDataSource"%>
<%@page import="java.util.List"%>
<%@page import="com.alzatezabala.fp.persistencia.EntidadBancariaDAO"%>
<%@page import="com.alzatezabala.fp.persistencia.EntidadBancariaDAOImplJDBC"%>
<%@page import="com.alzatezabala.fp.EntidadBancaria"%>
<%
    int idEntidadBancaria= Integer.parseInt(request.getParameter("idEntidadBancaria"));
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplDataSource();
    entidadBancariaDAO.delete(idEntidadBancaria);
    
%>
