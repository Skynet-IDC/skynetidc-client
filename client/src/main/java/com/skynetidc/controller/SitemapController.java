package com.skynetidc.controller;

import jakarta.xml.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class SitemapController {

	@RequestMapping(value = "/sitemap.xml", method = GET)
	@ResponseBody
	public XmlUrlSet main() {
		XmlUrlSet xmlUrlSet = new XmlUrlSet();
		create(xmlUrlSet, "", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/link-1", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/link-2", XmlUrl.Priority.MEDIUM);
		return xmlUrlSet;
	}

	private void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority) {
		xmlUrlSet.addUrl(new XmlUrl("https://skynetidc.com" + link, priority));
	}

	@XmlAccessorType(value = XmlAccessType.NONE)
	@XmlRootElement(name = "urlset", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9")
	class XmlUrlSet {

		@XmlElements({ @XmlElement(name = "url", type = XmlUrl.class) })
		private Collection<XmlUrl> xmlUrls = new ArrayList<>();

		public void addUrl(XmlUrl xmlUrl) {
			xmlUrls.add(xmlUrl);
		}

		public Collection<XmlUrl> getXmlUrls() {
			return xmlUrls;
		}

	}

	@XmlAccessorType(value = XmlAccessType.NONE)
	@XmlRootElement(name = "url")
	class XmlUrl {

		public enum Priority {

			HIGH("1.0"), MEDIUM("0.5");

			private String value;

			Priority(String value) {
				this.value = value;
			}

			public String getValue() {
				return value;
			}

		}

		@XmlElement
		private String loc;

		@XmlElement
		private String lastmod = LocalDateTime.now().toString();

		@XmlElement
		private String changefreq = "daily";

		@XmlElement
		private String priority;

		public XmlUrl() {
		}

		public XmlUrl(String loc, Priority priority) {
			this.loc = loc;
			this.priority = priority.getValue();
		}

		public String getLoc() {
			return loc;
		}

		public String getPriority() {
			return priority;
		}

		public String getChangefreq() {
			return changefreq;
		}

		public String getLastmod() {
			return lastmod;
		}

	}

}
