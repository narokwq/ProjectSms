package com.br.interceptores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();

		Pattern r = Pattern.compile(".*/aluno/[A-Z]*/form$");
		Pattern r2 = Pattern.compile(".*/aluno/[A-Z]*/salvar$");
		Matcher m = r.matcher(uri);
		Matcher m2 = r2.matcher(uri);
		System.out.println(uri);
		if (uri.endsWith("login") || uri.endsWith("logar") || uri.endsWith("cliente/form")
				|| uri.endsWith("cliente/save") || m.find() || m2.find()) {
			return true;
		}
		if (session.getAttribute("usuario") != null) {
			return true;
		}
		response.sendRedirect(contextPath + "/login");

		return false;
	}
}