<%-- 
    Document   : get.json.jsp
    Created on : Sep 17, 2014, 11:53:34 AM
    Author     : eslem
--%>
<%@page import="com.alzatezabala.fp.presentacion.json.JSONConverterImplJackson"%>
<%@page import="com.alzatezabala.fp.presentacion.json.JSONConverter"%>
<%@page import="com.alzatezabala.fp.pojo.EntidadBancaria"%>
<%@page import="com.alzatezabala.fp.persistencia.impl.EntidadBancariaDAOImplDataSource"%>
<%@page import="com.alzatezabala.fp.persistencia.EntidadBancariaDAO"%>
<%
    int idEntidadBancaria = Integer.parseInt(request.getParameter("idEntidadBancaria"));

    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplDataSource();
    EntidadBancaria entidadBancaria = entidadBancariaDAO.get(idEntidadBancaria);
    
    JSONConverter jsonConverter= new JSONConverterImplJackson();
    
    
    String json=jsonConverter.toJSON(entidadBancaria);
    
    EntidadBancaria entidadBancaria2= (EntidadBancaria) jsonConverter.fromJSON(json, EntidadBancaria.class);
    
    out.print(jsonConverter.toJSON(entidadBancaria));
    

%>
