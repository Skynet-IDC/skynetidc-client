package com.skynetidc.controller;

import com.skynetidc.model.XmlUrl;
import com.skynetidc.model.XmlUrlSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class SitemapController {

	@RequestMapping(value = "/sitemap.xml", method = GET)
	@ResponseBody
	public XmlUrlSet sitemap() {
		XmlUrlSet xmlUrlSet = new XmlUrlSet();
		create(xmlUrlSet, "/", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/shared-hosting", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/vps-hosting", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/cloud-hosting", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/wordpress-hosting", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/dedicated-hosting", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/reseller-hosting", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/domain-checker", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/domain-transfer", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/domain-registration", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/whois", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/technology", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/data-center", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/faq", XmlUrl.Priority.MEDIUM);
		create(xmlUrlSet, "/support", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/contact", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/knowledgebase", XmlUrl.Priority.HIGH);
		return xmlUrlSet;
	}

	private void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority) {
		xmlUrlSet.addUrl(new XmlUrl("https://skynetidc.com" + link, priority));
	}

}
