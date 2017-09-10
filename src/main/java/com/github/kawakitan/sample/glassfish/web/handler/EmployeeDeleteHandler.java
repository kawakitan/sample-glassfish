/**
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

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kawakitan.sample.glassfish.service.EmployeeService;

/**
 *
 * @author kawakitan
 */
@WebServlet(urlPatterns = "/delete")
public class EmployeeDeleteHandler extends HttpServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = -4256350225133580540L;

	@Inject
	private EmployeeService employeeService;

	@Override
	protected void doPost(final HttpServletRequest pReq, final HttpServletResponse pResp) throws ServletException, IOException {
		final String employeeIdStr = pReq.getParameter("employee-id");
		try {
			final long employeeId = Long.parseLong(employeeIdStr);
			this.employeeService.delete(employeeId);
		} catch (final NumberFormatException e) {
		}

		pResp.sendRedirect("/");
	}
}
