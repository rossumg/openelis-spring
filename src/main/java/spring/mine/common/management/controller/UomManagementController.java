package spring.mine.common.management.controller;

import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mine.common.management.form.UomManagementForm;
import spring.mine.common.controller.BaseController;
import spring.mine.common.form.BaseForm;
import spring.mine.common.validator.BaseErrors;

@Controller
public class UomManagementController extends BaseController {
	@RequestMapping(value = "/UomManagement", method = RequestMethod.GET)
	public ModelAndView showUomManagement(HttpServletRequest request) {
		String forward = FWD_SUCCESS;
		UomManagementForm form = new UomManagementForm();
		form.setFormName("uomManagementForm");
		form.setFormAction("");
		BaseErrors errors = new BaseErrors();
		ModelAndView mv = checkUserAndSetup(form, errors, request);

		if (errors.hasErrors()) {
			return mv;
		}

		return findForward(forward, form);
	}

	protected ModelAndView findLocalForward(String forward, BaseForm form) {
		if ("success".equals(forward)) {
			return new ModelAndView("uomManagementDefinition", "form", form);
		} else {
			return new ModelAndView("PageNotFound");
		}
	}

	protected String getPageTitleKey() {
		return null;
	}

	protected String getPageSubtitleKey() {
		return null;
	}
}