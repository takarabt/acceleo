/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.ui.interpreter.language;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.ui.interpreter.view.Variable;
import org.eclipse.emf.ecore.EObject;

/**
 * This will be used to pass the current compilation context to the language interpreter.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class InterpreterContext {
	/** This will be initialized with the list of EObjects that have been selected in the workbench. */
	private final List<EObject> targetEObjects;

	/** List of the variables currently accessible by the interpreter. */
	private final List<Variable> variables;

	/** The full expression currently written in the interpreter's source viewer. */
	private final String expression;

	/**
	 * The part of the full expression that was selected by the user. Only useful if the interpreter can
	 * operate on partial expressions.
	 */
	private final String selectedExpression;

	/**
	 * Instantiates this context.
	 * 
	 * @param expression
	 *            The full expression currently written in the interpreter's source viewer.
	 * @param selectedExpression
	 *            The selected part of the source viewer's expression.
	 * @param variables
	 *            The variables currently accessible by the interpreter.
	 */
	public InterpreterContext(String expression, String selectedExpression, List<EObject> targetEObjects,
			List<Variable> variables) {
		this.expression = expression;
		this.selectedExpression = selectedExpression;
		this.targetEObjects = targetEObjects;
		this.variables = variables;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param context
	 *            The context we are to copy.
	 */
	public InterpreterContext(InterpreterContext context) {
		this.expression = context.expression;
		this.selectedExpression = context.selectedExpression;
		this.targetEObjects = new ArrayList<EObject>(context.targetEObjects);
		this.variables = new ArrayList<Variable>(context.variables);
	}

	/**
	 * Returns the expression currently written in the interpreter's source viewer.
	 * 
	 * @return The expression currently written in the interpreter's source viewer.
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Returns the list of EObjects that have been selected in the workbench.
	 * 
	 * @return The list of EObjects that have been selected in the workbench.
	 */
	public List<EObject> getTargetEObjects() {
		return targetEObjects;
	}

	/**
	 * Returns the variables currently accessible by the interpreter.
	 * 
	 * @return The variables currently accessible by the interpreter.
	 */
	public List<Variable> getVariables() {
		return variables;
	}

	/**
	 * Returns the part of this expression that was selected in the source viewer.
	 * 
	 * @return The part of this expression that was selected in the source viewer.
	 */
	public String getPartialExpression() {
		return selectedExpression;
	}
}