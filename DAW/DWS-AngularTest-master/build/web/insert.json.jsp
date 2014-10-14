<%-- 
    Document   : update.json.jsp
    Created on : Sep 17, 2014, 11:59:25 AM
    Author     : eslem
--%>

<%@page import="com.alzatezabala.fp.persistencia.impl.EntidadBancariaDAOImplJDBC"%>
<%@page import="com.alzatezabala.fp.presentacion.json.JSONConverterImplJackson"%>
<%@page import="com.alzatezabala.fp.presentacion.json.JSONConverter"%>
<%@page import="com.alzatezabala.fp.pojo.EntidadBancaria"%>
<%@page import="com.alzatezabala.fp.persistencia.impl.EntidadBancariaDAOImplDataSource"%>
<%@page import="com.alzatezabala.fp.persistencia.EntidadBancariaDAO"%>
<%
    String nombre= request.getParameter("nombre");
    String codigoEntidad= request.getParameter("codigoEntidad");
    
    EntidadBancaria entidadBancaria= new EntidadBancaria();
    entidadBancaria.setNombre(nombre);
    entidadBancaria.setCodigoEntidad(codigoEntidad);
    
    EntidadBancariaDAO entidadBancariaDAO= new EntidadBancariaDAOImplJDBC();
    EntidadBancaria entidadBancaria2= entidadBancariaDAO.insert(entidadBancaria);

%>

{
"idEntidadBancaria":<%=entidadBancaria2.getIdEntidad()%>,
"nombre":<%=entidadBancaria2.getNombre()%>,
"codigoEntidad": <%=entidadBancaria2.getCodigoEntrada()%>,
"fechaResultado": <%=entidadBancaria2.getFechaCreacion()%>
}

