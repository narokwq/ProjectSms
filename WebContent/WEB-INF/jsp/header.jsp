<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link href="<c:url value ="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value ="/resources/css/bootstrap-theme.css" />" rel="stylesheet">
    <link href="<c:url value ="/resources/css/font-awesome.min.css" />" rel="stylesheet" />
    <link href="<c:url value ="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<section id="container" class="">
    <header class="header bg_nav" >
        <a href="<c:url value ="/home" />" class="logo">Plim <span class="lite">Interativo</span></a>
        <div class="top-nav notification-row">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="<c:url value ="/logout" />">
                        <span class="logout">Logout</span>
                    </a>
        </div>
    </header>
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li class="active">
                    <a class="" href="<c:url value ="/home" />">
                        <i class="fa fa-home" aria-hidden="true"></i>
                        <span>Salas</span>
                    </a>
                </li>

            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>