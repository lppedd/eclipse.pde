package org.eclipse.pde.internal.feature;
/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */

import org.eclipse.core.resources.*;
import org.eclipse.jface.wizard.*;
import org.eclipse.pde.internal.*;

public class BuildPluginWizard extends Wizard {
	private IFile pluginBaseFile;
	private BuildPluginWizardPage mainPage;
	private boolean fragment;

public BuildPluginWizard(IFile pluginBaseFile, boolean fragment) {
	setDefaultPageImageDescriptor(PDEPluginImages.DESC_NEWFTRPRJ_WIZ);
	setDialogSettings(PDEPlugin.getDefault().getDialogSettings());
	setNeedsProgressMonitor(true);
	this.pluginBaseFile = pluginBaseFile;
	this.fragment = fragment;
}
public void addPages() {
	mainPage = new BuildPluginWizardPage(pluginBaseFile, fragment);
	addPage(mainPage);
}
public boolean performFinish() {
	return mainPage.finish();
}
}
