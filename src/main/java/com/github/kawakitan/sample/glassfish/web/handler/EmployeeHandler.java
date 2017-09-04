/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kawakitan.sample.glassfish.web.handler;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kawakitan.sample.glassfish.entity.Employee;
import com.github.kawakitan.sample.glassfish.service.EmployeeService;

/**
 *
 * @author kawakitan
 */
@WebServlet(urlPatterns = "/")
public class EmployeeHandler extends HttpServlet {

	private static final long serialVersionUID = -77372621606238027L;

	@Inject
	private EmployeeService employeeService;

	@Override
	protected void doGet(final HttpServletRequest pReq, final HttpServletResponse pResp) throws ServletException, IOException {
		final List<Employee> emps = this.employeeService.getAll();
		pReq.setAttribute("emps", emps);

		pReq.getRequestDispatcher("WEB-INF/employee.jsp").forward(pReq, pResp);
	}

	@Override
	protected void doPost(final HttpServletRequest pReq, final HttpServletResponse pResp) throws ServletException, IOException {
		final String empName = pReq.getParameter("employee-name");
		this.employeeService.insert(empName);

		pResp.sendRedirect("/");
	}
}
