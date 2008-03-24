/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.pde.internal.ds.core.text;

import org.eclipse.jface.text.IDocument;
import org.eclipse.pde.core.IModel;
import org.eclipse.pde.core.IWritable;
import org.eclipse.pde.internal.core.NLResourceHelper;
import org.eclipse.pde.internal.core.text.XMLEditingModel;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Model describing the elements of a declarative services xml file.
 * 
 * @since 3.4
 */
public class DSModel extends XMLEditingModel {

	private DSDocumentHandler fHandler;
	private DSDocumentFactory fFactory;
	private DSRoot fRoot;

	public DSModel(IDocument document, boolean isReconciling) {
		super(document, isReconciling);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.pde.internal.core.text.XMLEditingModel#createDocumentHandler(org.eclipse.pde.core.IModel, boolean)
	 */
	protected DefaultHandler createDocumentHandler(IModel model, boolean reconciling) {
		if (fHandler == null) {
			fHandler = new DSDocumentHandler(this, reconciling);
		}
		return fHandler;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.pde.internal.core.text.AbstractEditingModel#createNLResourceHelper()
	 */
	protected NLResourceHelper createNLResourceHelper() {
		// Not needed
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.pde.internal.core.icheatsheet.simple.ITocModel#getFactory()
	 */
	public DSDocumentFactory getFactory() {
		if (fFactory == null) {
			fFactory = new DSDocumentFactory(this);
		}
		return fFactory;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.pde.internal.core.icheatsheet.simple.ITocModel#getToc()
	 */
	public DSRoot getDSRoot() {
		if (fRoot == null) {
			fRoot = getFactory().createRoot();
		}
		return fRoot;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.pde.internal.core.text.XMLEditingModel#getRoot()
	 */
	protected IWritable getRoot() {
		return getDSRoot();
	}

}
