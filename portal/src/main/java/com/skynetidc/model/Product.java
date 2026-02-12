package com.skynetidc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tblproducts")
public class Product {

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotNull
	@Lob
	@Column(name = "type", nullable = false)
	private String type;

	@NotNull
	@Column(name = "gid", nullable = false)
	private Long gid;

	@NotNull
	@Lob
	@Column(name = "name", nullable = false)
	private String name;

	@Size(max = 128)
	@NotNull
	@ColumnDefault("''")
	@Column(name = "slug", nullable = false, length = 128)
	private String slug;

	@NotNull
	@Lob
	@Column(name = "description", nullable = false)
	private String description;

	@NotNull
	@Column(name = "hidden", nullable = false)
	private Boolean hidden = false;

	@NotNull
	@Column(name = "showdomainoptions", nullable = false)
	private Boolean showdomainoptions = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "welcomeemail", nullable = false)
	private Integer welcomeemail;

	@NotNull
	@Column(name = "stockcontrol", nullable = false)
	private Boolean stockcontrol = false;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "qty", nullable = false)
	private Integer qty;

	@NotNull
	@Column(name = "proratabilling", nullable = false)
	private Boolean proratabilling = false;

	@NotNull
	@Column(name = "proratadate", nullable = false)
	private Integer proratadate;

	@NotNull
	@Column(name = "proratachargenextmonth", nullable = false)
	private Integer proratachargenextmonth;

	@NotNull
	@Lob
	@Column(name = "paytype", nullable = false)
	private String paytype;

	@NotNull
	@Column(name = "allowqty", nullable = false)
	private Integer allowqty;

	@NotNull
	@Lob
	@Column(name = "subdomain", nullable = false)
	private String subdomain;

	@NotNull
	@Lob
	@Column(name = "autosetup", nullable = false)
	private String autosetup;

	@NotNull
	@Lob
	@Column(name = "servertype", nullable = false)
	private String servertype;

	@NotNull
	@Column(name = "servergroup", nullable = false)
	private Integer servergroup;

	@NotNull
	@Lob
	@Column(name = "configoption1", nullable = false)
	private String configoption1;

	@NotNull
	@Lob
	@Column(name = "configoption2", nullable = false)
	private String configoption2;

	@NotNull
	@Lob
	@Column(name = "configoption3", nullable = false)
	private String configoption3;

	@NotNull
	@Lob
	@Column(name = "configoption4", nullable = false)
	private String configoption4;

	@NotNull
	@Lob
	@Column(name = "configoption5", nullable = false)
	private String configoption5;

	@NotNull
	@Lob
	@Column(name = "configoption6", nullable = false)
	private String configoption6;

	@NotNull
	@Lob
	@Column(name = "configoption7", nullable = false)
	private String configoption7;

	@NotNull
	@Lob
	@Column(name = "configoption8", nullable = false)
	private String configoption8;

	@NotNull
	@Lob
	@Column(name = "configoption9", nullable = false)
	private String configoption9;

	@NotNull
	@Lob
	@Column(name = "configoption10", nullable = false)
	private String configoption10;

	@NotNull
	@Lob
	@Column(name = "configoption11", nullable = false)
	private String configoption11;

	@NotNull
	@Lob
	@Column(name = "configoption12", nullable = false)
	private String configoption12;

	@NotNull
	@Lob
	@Column(name = "configoption13", nullable = false)
	private String configoption13;

	@NotNull
	@Lob
	@Column(name = "configoption14", nullable = false)
	private String configoption14;

	@NotNull
	@Lob
	@Column(name = "configoption15", nullable = false)
	private String configoption15;

	@NotNull
	@Lob
	@Column(name = "configoption16", nullable = false)
	private String configoption16;

	@NotNull
	@Lob
	@Column(name = "configoption17", nullable = false)
	private String configoption17;

	@NotNull
	@Lob
	@Column(name = "configoption18", nullable = false)
	private String configoption18;

	@NotNull
	@Lob
	@Column(name = "configoption19", nullable = false)
	private String configoption19;

	@NotNull
	@Lob
	@Column(name = "configoption20", nullable = false)
	private String configoption20;

	@NotNull
	@Lob
	@Column(name = "configoption21", nullable = false)
	private String configoption21;

	@NotNull
	@Lob
	@Column(name = "configoption22", nullable = false)
	private String configoption22;

	@NotNull
	@Lob
	@Column(name = "configoption23", nullable = false)
	private String configoption23;

	@NotNull
	@Lob
	@Column(name = "configoption24", nullable = false)
	private String configoption24;

	@NotNull
	@Lob
	@Column(name = "freedomain", nullable = false)
	private String freedomain;

	@NotNull
	@Lob
	@Column(name = "freedomainpaymentterms", nullable = false)
	private String freedomainpaymentterms;

	@NotNull
	@Lob
	@Column(name = "freedomaintlds", nullable = false)
	private String freedomaintlds;

	@NotNull
	@Column(name = "recurringcycles", nullable = false)
	private Integer recurringcycles;

	@NotNull
	@Column(name = "autoterminatedays", nullable = false)
	private Integer autoterminatedays;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "autoterminateemail", nullable = false)
	private Integer autoterminateemail;

	@NotNull
	@Column(name = "configoptionsupgrade", nullable = false)
	private Boolean configoptionsupgrade = false;

	@NotNull
	@Lob
	@Column(name = "billingcycleupgrade", nullable = false)
	private String billingcycleupgrade;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "upgradeemail", nullable = false)
	private Integer upgradeemail;

	@Size(max = 10)
	@NotNull
	@Column(name = "overagesenabled", nullable = false, length = 10)
	private String overagesenabled;

	@NotNull
	@Column(name = "overagesdisklimit", nullable = false)
	private Integer overagesdisklimit;

	@NotNull
	@Column(name = "overagesbwlimit", nullable = false)
	private Integer overagesbwlimit;

	@NotNull
	@Column(name = "overagesdiskprice", nullable = false, precision = 6, scale = 4)
	private BigDecimal overagesdiskprice;

	@NotNull
	@Column(name = "overagesbwprice", nullable = false, precision = 6, scale = 4)
	private BigDecimal overagesbwprice;

	@NotNull
	@Column(name = "tax", nullable = false)
	private Boolean tax = false;

	@NotNull
	@Column(name = "affiliateonetime", nullable = false)
	private Boolean affiliateonetime = false;

	@NotNull
	@Lob
	@Column(name = "affiliatepaytype", nullable = false)
	private String affiliatepaytype;

	@NotNull
	@Column(name = "affiliatepayamount", nullable = false, precision = 16, scale = 2)
	private BigDecimal affiliatepayamount;

	@NotNull
	@ColumnDefault("0")
	@Column(name = "`order`", nullable = false)
	private Integer order;

	@NotNull
	@Column(name = "retired", nullable = false)
	private Boolean retired = false;

	@NotNull
	@Column(name = "is_featured", nullable = false)
	private Boolean isFeatured = false;

	@NotNull
	@Lob
	@Column(name = "color", nullable = false)
	private String color;

	@NotNull
	@Lob
	@Column(name = "tagline", nullable = false)
	private String tagline;

	@NotNull
	@Lob
	@Column(name = "short_description", nullable = false)
	private String shortDescription;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@ColumnDefault("'0000-00-00 00:00:00'")
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Boolean getShowdomainoptions() {
		return showdomainoptions;
	}

	public void setShowdomainoptions(Boolean showdomainoptions) {
		this.showdomainoptions = showdomainoptions;
	}

	public Integer getWelcomeemail() {
		return welcomeemail;
	}

	public void setWelcomeemail(Integer welcomeemail) {
		this.welcomeemail = welcomeemail;
	}

	public Boolean getStockcontrol() {
		return stockcontrol;
	}

	public void setStockcontrol(Boolean stockcontrol) {
		this.stockcontrol = stockcontrol;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Boolean getProratabilling() {
		return proratabilling;
	}

	public void setProratabilling(Boolean proratabilling) {
		this.proratabilling = proratabilling;
	}

	public Integer getProratadate() {
		return proratadate;
	}

	public void setProratadate(Integer proratadate) {
		this.proratadate = proratadate;
	}

	public Integer getProratachargenextmonth() {
		return proratachargenextmonth;
	}

	public void setProratachargenextmonth(Integer proratachargenextmonth) {
		this.proratachargenextmonth = proratachargenextmonth;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public Integer getAllowqty() {
		return allowqty;
	}

	public void setAllowqty(Integer allowqty) {
		this.allowqty = allowqty;
	}

	public String getSubdomain() {
		return subdomain;
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public String getAutosetup() {
		return autosetup;
	}

	public void setAutosetup(String autosetup) {
		this.autosetup = autosetup;
	}

	public String getServertype() {
		return servertype;
	}

	public void setServertype(String servertype) {
		this.servertype = servertype;
	}

	public Integer getServergroup() {
		return servergroup;
	}

	public void setServergroup(Integer servergroup) {
		this.servergroup = servergroup;
	}

	public String getConfigoption1() {
		return configoption1;
	}

	public void setConfigoption1(String configoption1) {
		this.configoption1 = configoption1;
	}

	public String getConfigoption2() {
		return configoption2;
	}

	public void setConfigoption2(String configoption2) {
		this.configoption2 = configoption2;
	}

	public String getConfigoption3() {
		return configoption3;
	}

	public void setConfigoption3(String configoption3) {
		this.configoption3 = configoption3;
	}

	public String getConfigoption4() {
		return configoption4;
	}

	public void setConfigoption4(String configoption4) {
		this.configoption4 = configoption4;
	}

	public String getConfigoption5() {
		return configoption5;
	}

	public void setConfigoption5(String configoption5) {
		this.configoption5 = configoption5;
	}

	public String getConfigoption6() {
		return configoption6;
	}

	public void setConfigoption6(String configoption6) {
		this.configoption6 = configoption6;
	}

	public String getConfigoption7() {
		return configoption7;
	}

	public void setConfigoption7(String configoption7) {
		this.configoption7 = configoption7;
	}

	public String getConfigoption8() {
		return configoption8;
	}

	public void setConfigoption8(String configoption8) {
		this.configoption8 = configoption8;
	}

	public String getConfigoption9() {
		return configoption9;
	}

	public void setConfigoption9(String configoption9) {
		this.configoption9 = configoption9;
	}

	public String getConfigoption10() {
		return configoption10;
	}

	public void setConfigoption10(String configoption10) {
		this.configoption10 = configoption10;
	}

	public String getConfigoption11() {
		return configoption11;
	}

	public void setConfigoption11(String configoption11) {
		this.configoption11 = configoption11;
	}

	public String getConfigoption12() {
		return configoption12;
	}

	public void setConfigoption12(String configoption12) {
		this.configoption12 = configoption12;
	}

	public String getConfigoption13() {
		return configoption13;
	}

	public void setConfigoption13(String configoption13) {
		this.configoption13 = configoption13;
	}

	public String getConfigoption14() {
		return configoption14;
	}

	public void setConfigoption14(String configoption14) {
		this.configoption14 = configoption14;
	}

	public String getConfigoption15() {
		return configoption15;
	}

	public void setConfigoption15(String configoption15) {
		this.configoption15 = configoption15;
	}

	public String getConfigoption16() {
		return configoption16;
	}

	public void setConfigoption16(String configoption16) {
		this.configoption16 = configoption16;
	}

	public String getConfigoption17() {
		return configoption17;
	}

	public void setConfigoption17(String configoption17) {
		this.configoption17 = configoption17;
	}

	public String getConfigoption18() {
		return configoption18;
	}

	public void setConfigoption18(String configoption18) {
		this.configoption18 = configoption18;
	}

	public String getConfigoption19() {
		return configoption19;
	}

	public void setConfigoption19(String configoption19) {
		this.configoption19 = configoption19;
	}

	public String getConfigoption20() {
		return configoption20;
	}

	public void setConfigoption20(String configoption20) {
		this.configoption20 = configoption20;
	}

	public String getConfigoption21() {
		return configoption21;
	}

	public void setConfigoption21(String configoption21) {
		this.configoption21 = configoption21;
	}

	public String getConfigoption22() {
		return configoption22;
	}

	public void setConfigoption22(String configoption22) {
		this.configoption22 = configoption22;
	}

	public String getConfigoption23() {
		return configoption23;
	}

	public void setConfigoption23(String configoption23) {
		this.configoption23 = configoption23;
	}

	public String getConfigoption24() {
		return configoption24;
	}

	public void setConfigoption24(String configoption24) {
		this.configoption24 = configoption24;
	}

	public String getFreedomain() {
		return freedomain;
	}

	public void setFreedomain(String freedomain) {
		this.freedomain = freedomain;
	}

	public String getFreedomainpaymentterms() {
		return freedomainpaymentterms;
	}

	public void setFreedomainpaymentterms(String freedomainpaymentterms) {
		this.freedomainpaymentterms = freedomainpaymentterms;
	}

	public String getFreedomaintlds() {
		return freedomaintlds;
	}

	public void setFreedomaintlds(String freedomaintlds) {
		this.freedomaintlds = freedomaintlds;
	}

	public Integer getRecurringcycles() {
		return recurringcycles;
	}

	public void setRecurringcycles(Integer recurringcycles) {
		this.recurringcycles = recurringcycles;
	}

	public Integer getAutoterminatedays() {
		return autoterminatedays;
	}

	public void setAutoterminatedays(Integer autoterminatedays) {
		this.autoterminatedays = autoterminatedays;
	}

	public Integer getAutoterminateemail() {
		return autoterminateemail;
	}

	public void setAutoterminateemail(Integer autoterminateemail) {
		this.autoterminateemail = autoterminateemail;
	}

	public Boolean getConfigoptionsupgrade() {
		return configoptionsupgrade;
	}

	public void setConfigoptionsupgrade(Boolean configoptionsupgrade) {
		this.configoptionsupgrade = configoptionsupgrade;
	}

	public String getBillingcycleupgrade() {
		return billingcycleupgrade;
	}

	public void setBillingcycleupgrade(String billingcycleupgrade) {
		this.billingcycleupgrade = billingcycleupgrade;
	}

	public Integer getUpgradeemail() {
		return upgradeemail;
	}

	public void setUpgradeemail(Integer upgradeemail) {
		this.upgradeemail = upgradeemail;
	}

	public String getOveragesenabled() {
		return overagesenabled;
	}

	public void setOveragesenabled(String overagesenabled) {
		this.overagesenabled = overagesenabled;
	}

	public Integer getOveragesdisklimit() {
		return overagesdisklimit;
	}

	public void setOveragesdisklimit(Integer overagesdisklimit) {
		this.overagesdisklimit = overagesdisklimit;
	}

	public Integer getOveragesbwlimit() {
		return overagesbwlimit;
	}

	public void setOveragesbwlimit(Integer overagesbwlimit) {
		this.overagesbwlimit = overagesbwlimit;
	}

	public BigDecimal getOveragesdiskprice() {
		return overagesdiskprice;
	}

	public void setOveragesdiskprice(BigDecimal overagesdiskprice) {
		this.overagesdiskprice = overagesdiskprice;
	}

	public BigDecimal getOveragesbwprice() {
		return overagesbwprice;
	}

	public void setOveragesbwprice(BigDecimal overagesbwprice) {
		this.overagesbwprice = overagesbwprice;
	}

	public Boolean getTax() {
		return tax;
	}

	public void setTax(Boolean tax) {
		this.tax = tax;
	}

	public Boolean getAffiliateonetime() {
		return affiliateonetime;
	}

	public void setAffiliateonetime(Boolean affiliateonetime) {
		this.affiliateonetime = affiliateonetime;
	}

	public String getAffiliatepaytype() {
		return affiliatepaytype;
	}

	public void setAffiliatepaytype(String affiliatepaytype) {
		this.affiliatepaytype = affiliatepaytype;
	}

	public BigDecimal getAffiliatepayamount() {
		return affiliatepayamount;
	}

	public void setAffiliatepayamount(BigDecimal affiliatepayamount) {
		this.affiliatepayamount = affiliatepayamount;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getRetired() {
		return retired;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public Boolean getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(Boolean isFeatured) {
		this.isFeatured = isFeatured;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

}
