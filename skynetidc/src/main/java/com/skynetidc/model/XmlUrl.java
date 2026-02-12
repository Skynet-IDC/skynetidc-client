package com.skynetidc.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "url")
public class XmlUrl {

	@Getter
	public enum Priority {

		HIGH("1.0"), MEDIUM("0.5");

		private String value;

		Priority(String value) {
			this.value = value;
		}

	}

	@XmlElement
	private String loc;

	@XmlElement
	private String lastMod = LocalDateTime.now().toString();

	@XmlElement
	private String changeFreq = "daily";

	@XmlElement
	private String priority;

	public XmlUrl() {
	}

	public XmlUrl(String loc, Priority priority) {
		this.loc = loc;
		this.priority = priority.getValue();
	}

}
