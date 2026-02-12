package com.skynetidc.model;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "urlset", namespace = "https://www.sitemaps.org/schemas/sitemap/0.9")
public class XmlUrlSet {

	@XmlElements({ @XmlElement(name = "url", type = XmlUrl.class) })
	private Collection<XmlUrl> xmlUrls = new ArrayList<>();

	public void addUrl(XmlUrl xmlUrl) {
		xmlUrls.add(xmlUrl);
	}

}
