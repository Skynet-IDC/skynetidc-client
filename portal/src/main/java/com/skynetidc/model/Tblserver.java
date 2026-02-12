package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "tblservers")
public class Tblserver {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Lob
	@Column(name = "ipaddress", nullable = false)
	private String ipaddress;

	@NotNull
	@Lob
	@Column(name = "assignedips", nullable = false)
	private String assignedips;

	@NotNull
	@Lob
	@Column(name = "hostname", nullable = false)
	private String hostname;

	@NotNull
	@ColumnDefault("0.00")
	@Column(name = "monthlycost", nullable = false, precision = 16, scale = 2)
	private BigDecimal monthlycost;

	@NotNull
	@Lob
	@Column(name = "noc", nullable = false)
	private String noc;

	@NotNull
	@Lob
	@Column(name = "statusaddress", nullable = false)
	private String statusaddress;

	@NotNull
	@Lob
	@Column(name = "nameserver1", nullable = false)
	private String nameserver1;

	@NotNull
	@Lob
	@Column(name = "nameserver1ip", nullable = false)
	private String nameserver1ip;

	@NotNull
	@Lob
	@Column(name = "nameserver2", nullable = false)
	private String nameserver2;

	@NotNull
	@Lob
	@Column(name = "nameserver2ip", nullable = false)
	private String nameserver2ip;

	@NotNull
	@Lob
	@Column(name = "nameserver3", nullable = false)
	private String nameserver3;

	@NotNull
	@Lob
	@Column(name = "nameserver3ip", nullable = false)
	private String nameserver3ip;

	@NotNull
	@Lob
	@Column(name = "nameserver4", nullable = false)
	private String nameserver4;

	@NotNull
	@Lob
	@Column(name = "nameserver4ip", nullable = false)
	private String nameserver4ip;

	@NotNull
	@Lob
	@Column(name = "nameserver5", nullable = false)
	private String nameserver5;

	@NotNull
	@Lob
	@Column(name = "nameserver5ip", nullable = false)
	private String nameserver5ip;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "maxaccounts", nullable = false)
	private Integer maxaccounts;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@Lob
	@Column(name = "username", nullable = false)
	private String username;

	@NotNull
	@Lob
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	@Lob
	@Column(name = "accesshash", nullable = false)
	private String accesshash;

	@NotNull
	@Lob
	@Column(name = "secure", nullable = false)
	private String secure;

	@Column(name = "port")
	private Integer port;

	@NotNull
	@Column(name = "active", nullable = false)
	private Integer active;

	@NotNull
	@Column(name = "disabled", nullable = false)
	private Integer disabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getAssignedips() {
		return assignedips;
	}

	public void setAssignedips(String assignedips) {
		this.assignedips = assignedips;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public BigDecimal getMonthlycost() {
		return monthlycost;
	}

	public void setMonthlycost(BigDecimal monthlycost) {
		this.monthlycost = monthlycost;
	}

	public String getNoc() {
		return noc;
	}

	public void setNoc(String noc) {
		this.noc = noc;
	}

	public String getStatusaddress() {
		return statusaddress;
	}

	public void setStatusaddress(String statusaddress) {
		this.statusaddress = statusaddress;
	}

	public String getNameserver1() {
		return nameserver1;
	}

	public void setNameserver1(String nameserver1) {
		this.nameserver1 = nameserver1;
	}

	public String getNameserver1ip() {
		return nameserver1ip;
	}

	public void setNameserver1ip(String nameserver1ip) {
		this.nameserver1ip = nameserver1ip;
	}

	public String getNameserver2() {
		return nameserver2;
	}

	public void setNameserver2(String nameserver2) {
		this.nameserver2 = nameserver2;
	}

	public String getNameserver2ip() {
		return nameserver2ip;
	}

	public void setNameserver2ip(String nameserver2ip) {
		this.nameserver2ip = nameserver2ip;
	}

	public String getNameserver3() {
		return nameserver3;
	}

	public void setNameserver3(String nameserver3) {
		this.nameserver3 = nameserver3;
	}

	public String getNameserver3ip() {
		return nameserver3ip;
	}

	public void setNameserver3ip(String nameserver3ip) {
		this.nameserver3ip = nameserver3ip;
	}

	public String getNameserver4() {
		return nameserver4;
	}

	public void setNameserver4(String nameserver4) {
		this.nameserver4 = nameserver4;
	}

	public String getNameserver4ip() {
		return nameserver4ip;
	}

	public void setNameserver4ip(String nameserver4ip) {
		this.nameserver4ip = nameserver4ip;
	}

	public String getNameserver5() {
		return nameserver5;
	}

	public void setNameserver5(String nameserver5) {
		this.nameserver5 = nameserver5;
	}

	public String getNameserver5ip() {
		return nameserver5ip;
	}

	public void setNameserver5ip(String nameserver5ip) {
		this.nameserver5ip = nameserver5ip;
	}

	public Integer getMaxaccounts() {
		return maxaccounts;
	}

	public void setMaxaccounts(Integer maxaccounts) {
		this.maxaccounts = maxaccounts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccesshash() {
		return accesshash;
	}

	public void setAccesshash(String accesshash) {
		this.accesshash = accesshash;
	}

	public String getSecure() {
		return secure;
	}

	public void setSecure(String secure) {
		this.secure = secure;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

}
