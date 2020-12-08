package cn.keking.model.database.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InventoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAutoidIsNull() {
            addCriterion("AutoId is null");
            return (Criteria) this;
        }

        public Criteria andAutoidIsNotNull() {
            addCriterion("AutoId is not null");
            return (Criteria) this;
        }

        public Criteria andAutoidEqualTo(Integer value) {
            addCriterion("AutoId =", value, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidNotEqualTo(Integer value) {
            addCriterion("AutoId <>", value, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidGreaterThan(Integer value) {
            addCriterion("AutoId >", value, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AutoId >=", value, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidLessThan(Integer value) {
            addCriterion("AutoId <", value, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidLessThanOrEqualTo(Integer value) {
            addCriterion("AutoId <=", value, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidIn(List<Integer> values) {
            addCriterion("AutoId in", values, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidNotIn(List<Integer> values) {
            addCriterion("AutoId not in", values, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidBetween(Integer value1, Integer value2) {
            addCriterion("AutoId between", value1, value2, "autoid");
            return (Criteria) this;
        }

        public Criteria andAutoidNotBetween(Integer value1, Integer value2) {
            addCriterion("AutoId not between", value1, value2, "autoid");
            return (Criteria) this;
        }

        public Criteria andCaccIdIsNull() {
            addCriterion("cAcc_Id is null");
            return (Criteria) this;
        }

        public Criteria andCaccIdIsNotNull() {
            addCriterion("cAcc_Id is not null");
            return (Criteria) this;
        }

        public Criteria andCaccIdEqualTo(String value) {
            addCriterion("cAcc_Id =", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdNotEqualTo(String value) {
            addCriterion("cAcc_Id <>", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdGreaterThan(String value) {
            addCriterion("cAcc_Id >", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdGreaterThanOrEqualTo(String value) {
            addCriterion("cAcc_Id >=", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdLessThan(String value) {
            addCriterion("cAcc_Id <", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdLessThanOrEqualTo(String value) {
            addCriterion("cAcc_Id <=", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdLike(String value) {
            addCriterion("cAcc_Id like", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdNotLike(String value) {
            addCriterion("cAcc_Id not like", value, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdIn(List<String> values) {
            addCriterion("cAcc_Id in", values, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdNotIn(List<String> values) {
            addCriterion("cAcc_Id not in", values, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdBetween(String value1, String value2) {
            addCriterion("cAcc_Id between", value1, value2, "caccId");
            return (Criteria) this;
        }

        public Criteria andCaccIdNotBetween(String value1, String value2) {
            addCriterion("cAcc_Id not between", value1, value2, "caccId");
            return (Criteria) this;
        }

        public Criteria andCinvcodeIsNull() {
            addCriterion("cInvCode is null");
            return (Criteria) this;
        }

        public Criteria andCinvcodeIsNotNull() {
            addCriterion("cInvCode is not null");
            return (Criteria) this;
        }

        public Criteria andCinvcodeEqualTo(String value) {
            addCriterion("cInvCode =", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotEqualTo(String value) {
            addCriterion("cInvCode <>", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeGreaterThan(String value) {
            addCriterion("cInvCode >", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cInvCode >=", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLessThan(String value) {
            addCriterion("cInvCode <", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLessThanOrEqualTo(String value) {
            addCriterion("cInvCode <=", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLike(String value) {
            addCriterion("cInvCode like", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotLike(String value) {
            addCriterion("cInvCode not like", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeIn(List<String> values) {
            addCriterion("cInvCode in", values, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotIn(List<String> values) {
            addCriterion("cInvCode not in", values, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeBetween(String value1, String value2) {
            addCriterion("cInvCode between", value1, value2, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotBetween(String value1, String value2) {
            addCriterion("cInvCode not between", value1, value2, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeIsNull() {
            addCriterion("cInvAddCode is null");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeIsNotNull() {
            addCriterion("cInvAddCode is not null");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeEqualTo(String value) {
            addCriterion("cInvAddCode =", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotEqualTo(String value) {
            addCriterion("cInvAddCode <>", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeGreaterThan(String value) {
            addCriterion("cInvAddCode >", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cInvAddCode >=", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeLessThan(String value) {
            addCriterion("cInvAddCode <", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeLessThanOrEqualTo(String value) {
            addCriterion("cInvAddCode <=", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeLike(String value) {
            addCriterion("cInvAddCode like", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotLike(String value) {
            addCriterion("cInvAddCode not like", value, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeIn(List<String> values) {
            addCriterion("cInvAddCode in", values, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotIn(List<String> values) {
            addCriterion("cInvAddCode not in", values, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeBetween(String value1, String value2) {
            addCriterion("cInvAddCode between", value1, value2, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvaddcodeNotBetween(String value1, String value2) {
            addCriterion("cInvAddCode not between", value1, value2, "cinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCinvnameIsNull() {
            addCriterion("cInvName is null");
            return (Criteria) this;
        }

        public Criteria andCinvnameIsNotNull() {
            addCriterion("cInvName is not null");
            return (Criteria) this;
        }

        public Criteria andCinvnameEqualTo(String value) {
            addCriterion("cInvName =", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameNotEqualTo(String value) {
            addCriterion("cInvName <>", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameGreaterThan(String value) {
            addCriterion("cInvName >", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameGreaterThanOrEqualTo(String value) {
            addCriterion("cInvName >=", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameLessThan(String value) {
            addCriterion("cInvName <", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameLessThanOrEqualTo(String value) {
            addCriterion("cInvName <=", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameLike(String value) {
            addCriterion("cInvName like", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameNotLike(String value) {
            addCriterion("cInvName not like", value, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameIn(List<String> values) {
            addCriterion("cInvName in", values, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameNotIn(List<String> values) {
            addCriterion("cInvName not in", values, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameBetween(String value1, String value2) {
            addCriterion("cInvName between", value1, value2, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvnameNotBetween(String value1, String value2) {
            addCriterion("cInvName not between", value1, value2, "cinvname");
            return (Criteria) this;
        }

        public Criteria andCinvstdIsNull() {
            addCriterion("cInvStd is null");
            return (Criteria) this;
        }

        public Criteria andCinvstdIsNotNull() {
            addCriterion("cInvStd is not null");
            return (Criteria) this;
        }

        public Criteria andCinvstdEqualTo(String value) {
            addCriterion("cInvStd =", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdNotEqualTo(String value) {
            addCriterion("cInvStd <>", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdGreaterThan(String value) {
            addCriterion("cInvStd >", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdGreaterThanOrEqualTo(String value) {
            addCriterion("cInvStd >=", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdLessThan(String value) {
            addCriterion("cInvStd <", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdLessThanOrEqualTo(String value) {
            addCriterion("cInvStd <=", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdLike(String value) {
            addCriterion("cInvStd like", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdNotLike(String value) {
            addCriterion("cInvStd not like", value, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdIn(List<String> values) {
            addCriterion("cInvStd in", values, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdNotIn(List<String> values) {
            addCriterion("cInvStd not in", values, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdBetween(String value1, String value2) {
            addCriterion("cInvStd between", value1, value2, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvstdNotBetween(String value1, String value2) {
            addCriterion("cInvStd not between", value1, value2, "cinvstd");
            return (Criteria) this;
        }

        public Criteria andCinvccodeIsNull() {
            addCriterion("cInvCCode is null");
            return (Criteria) this;
        }

        public Criteria andCinvccodeIsNotNull() {
            addCriterion("cInvCCode is not null");
            return (Criteria) this;
        }

        public Criteria andCinvccodeEqualTo(String value) {
            addCriterion("cInvCCode =", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeNotEqualTo(String value) {
            addCriterion("cInvCCode <>", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeGreaterThan(String value) {
            addCriterion("cInvCCode >", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeGreaterThanOrEqualTo(String value) {
            addCriterion("cInvCCode >=", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeLessThan(String value) {
            addCriterion("cInvCCode <", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeLessThanOrEqualTo(String value) {
            addCriterion("cInvCCode <=", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeLike(String value) {
            addCriterion("cInvCCode like", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeNotLike(String value) {
            addCriterion("cInvCCode not like", value, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeIn(List<String> values) {
            addCriterion("cInvCCode in", values, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeNotIn(List<String> values) {
            addCriterion("cInvCCode not in", values, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeBetween(String value1, String value2) {
            addCriterion("cInvCCode between", value1, value2, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvccodeNotBetween(String value1, String value2) {
            addCriterion("cInvCCode not between", value1, value2, "cinvccode");
            return (Criteria) this;
        }

        public Criteria andCinvcnameIsNull() {
            addCriterion("cInvCName is null");
            return (Criteria) this;
        }

        public Criteria andCinvcnameIsNotNull() {
            addCriterion("cInvCName is not null");
            return (Criteria) this;
        }

        public Criteria andCinvcnameEqualTo(String value) {
            addCriterion("cInvCName =", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameNotEqualTo(String value) {
            addCriterion("cInvCName <>", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameGreaterThan(String value) {
            addCriterion("cInvCName >", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameGreaterThanOrEqualTo(String value) {
            addCriterion("cInvCName >=", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameLessThan(String value) {
            addCriterion("cInvCName <", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameLessThanOrEqualTo(String value) {
            addCriterion("cInvCName <=", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameLike(String value) {
            addCriterion("cInvCName like", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameNotLike(String value) {
            addCriterion("cInvCName not like", value, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameIn(List<String> values) {
            addCriterion("cInvCName in", values, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameNotIn(List<String> values) {
            addCriterion("cInvCName not in", values, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameBetween(String value1, String value2) {
            addCriterion("cInvCName between", value1, value2, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCinvcnameNotBetween(String value1, String value2) {
            addCriterion("cInvCName not between", value1, value2, "cinvcname");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeIsNull() {
            addCriterion("cComUnitCode is null");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeIsNotNull() {
            addCriterion("cComUnitCode is not null");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeEqualTo(String value) {
            addCriterion("cComUnitCode =", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeNotEqualTo(String value) {
            addCriterion("cComUnitCode <>", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeGreaterThan(String value) {
            addCriterion("cComUnitCode >", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cComUnitCode >=", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeLessThan(String value) {
            addCriterion("cComUnitCode <", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeLessThanOrEqualTo(String value) {
            addCriterion("cComUnitCode <=", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeLike(String value) {
            addCriterion("cComUnitCode like", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeNotLike(String value) {
            addCriterion("cComUnitCode not like", value, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeIn(List<String> values) {
            addCriterion("cComUnitCode in", values, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeNotIn(List<String> values) {
            addCriterion("cComUnitCode not in", values, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeBetween(String value1, String value2) {
            addCriterion("cComUnitCode between", value1, value2, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitcodeNotBetween(String value1, String value2) {
            addCriterion("cComUnitCode not between", value1, value2, "ccomunitcode");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameIsNull() {
            addCriterion("cComUnitName is null");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameIsNotNull() {
            addCriterion("cComUnitName is not null");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameEqualTo(String value) {
            addCriterion("cComUnitName =", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameNotEqualTo(String value) {
            addCriterion("cComUnitName <>", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameGreaterThan(String value) {
            addCriterion("cComUnitName >", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameGreaterThanOrEqualTo(String value) {
            addCriterion("cComUnitName >=", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameLessThan(String value) {
            addCriterion("cComUnitName <", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameLessThanOrEqualTo(String value) {
            addCriterion("cComUnitName <=", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameLike(String value) {
            addCriterion("cComUnitName like", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameNotLike(String value) {
            addCriterion("cComUnitName not like", value, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameIn(List<String> values) {
            addCriterion("cComUnitName in", values, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameNotIn(List<String> values) {
            addCriterion("cComUnitName not in", values, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameBetween(String value1, String value2) {
            addCriterion("cComUnitName between", value1, value2, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andCcomunitnameNotBetween(String value1, String value2) {
            addCriterion("cComUnitName not between", value1, value2, "ccomunitname");
            return (Criteria) this;
        }

        public Criteria andDedateIsNull() {
            addCriterion("dEDate is null");
            return (Criteria) this;
        }

        public Criteria andDedateIsNotNull() {
            addCriterion("dEDate is not null");
            return (Criteria) this;
        }

        public Criteria andDedateEqualTo(Date value) {
            addCriterionForJDBCDate("dEDate =", value, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("dEDate <>", value, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateGreaterThan(Date value) {
            addCriterionForJDBCDate("dEDate >", value, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dEDate >=", value, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateLessThan(Date value) {
            addCriterionForJDBCDate("dEDate <", value, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dEDate <=", value, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateIn(List<Date> values) {
            addCriterionForJDBCDate("dEDate in", values, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("dEDate not in", values, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dEDate between", value1, value2, "dedate");
            return (Criteria) this;
        }

        public Criteria andDedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dEDate not between", value1, value2, "dedate");
            return (Criteria) this;
        }

        public Criteria andBinvbatchIsNull() {
            addCriterion("bInvBatch is null");
            return (Criteria) this;
        }

        public Criteria andBinvbatchIsNotNull() {
            addCriterion("bInvBatch is not null");
            return (Criteria) this;
        }

        public Criteria andBinvbatchEqualTo(Boolean value) {
            addCriterion("bInvBatch =", value, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchNotEqualTo(Boolean value) {
            addCriterion("bInvBatch <>", value, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchGreaterThan(Boolean value) {
            addCriterion("bInvBatch >", value, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bInvBatch >=", value, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchLessThan(Boolean value) {
            addCriterion("bInvBatch <", value, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchLessThanOrEqualTo(Boolean value) {
            addCriterion("bInvBatch <=", value, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchIn(List<Boolean> values) {
            addCriterion("bInvBatch in", values, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchNotIn(List<Boolean> values) {
            addCriterion("bInvBatch not in", values, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchBetween(Boolean value1, Boolean value2) {
            addCriterion("bInvBatch between", value1, value2, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvbatchNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bInvBatch not between", value1, value2, "binvbatch");
            return (Criteria) this;
        }

        public Criteria andBinvqualityIsNull() {
            addCriterion("bInvQuality is null");
            return (Criteria) this;
        }

        public Criteria andBinvqualityIsNotNull() {
            addCriterion("bInvQuality is not null");
            return (Criteria) this;
        }

        public Criteria andBinvqualityEqualTo(Boolean value) {
            addCriterion("bInvQuality =", value, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityNotEqualTo(Boolean value) {
            addCriterion("bInvQuality <>", value, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityGreaterThan(Boolean value) {
            addCriterion("bInvQuality >", value, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bInvQuality >=", value, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityLessThan(Boolean value) {
            addCriterion("bInvQuality <", value, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityLessThanOrEqualTo(Boolean value) {
            addCriterion("bInvQuality <=", value, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityIn(List<Boolean> values) {
            addCriterion("bInvQuality in", values, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityNotIn(List<Boolean> values) {
            addCriterion("bInvQuality not in", values, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityBetween(Boolean value1, Boolean value2) {
            addCriterion("bInvQuality between", value1, value2, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBinvqualityNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bInvQuality not between", value1, value2, "binvquality");
            return (Criteria) this;
        }

        public Criteria andBpurchaseIsNull() {
            addCriterion("bPurchase is null");
            return (Criteria) this;
        }

        public Criteria andBpurchaseIsNotNull() {
            addCriterion("bPurchase is not null");
            return (Criteria) this;
        }

        public Criteria andBpurchaseEqualTo(Boolean value) {
            addCriterion("bPurchase =", value, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseNotEqualTo(Boolean value) {
            addCriterion("bPurchase <>", value, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseGreaterThan(Boolean value) {
            addCriterion("bPurchase >", value, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bPurchase >=", value, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseLessThan(Boolean value) {
            addCriterion("bPurchase <", value, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseLessThanOrEqualTo(Boolean value) {
            addCriterion("bPurchase <=", value, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseIn(List<Boolean> values) {
            addCriterion("bPurchase in", values, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseNotIn(List<Boolean> values) {
            addCriterion("bPurchase not in", values, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseBetween(Boolean value1, Boolean value2) {
            addCriterion("bPurchase between", value1, value2, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBpurchaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bPurchase not between", value1, value2, "bpurchase");
            return (Criteria) this;
        }

        public Criteria andBselfIsNull() {
            addCriterion("bSelf is null");
            return (Criteria) this;
        }

        public Criteria andBselfIsNotNull() {
            addCriterion("bSelf is not null");
            return (Criteria) this;
        }

        public Criteria andBselfEqualTo(Boolean value) {
            addCriterion("bSelf =", value, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfNotEqualTo(Boolean value) {
            addCriterion("bSelf <>", value, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfGreaterThan(Boolean value) {
            addCriterion("bSelf >", value, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bSelf >=", value, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfLessThan(Boolean value) {
            addCriterion("bSelf <", value, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfLessThanOrEqualTo(Boolean value) {
            addCriterion("bSelf <=", value, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfIn(List<Boolean> values) {
            addCriterion("bSelf in", values, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfNotIn(List<Boolean> values) {
            addCriterion("bSelf not in", values, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfBetween(Boolean value1, Boolean value2) {
            addCriterion("bSelf between", value1, value2, "bself");
            return (Criteria) this;
        }

        public Criteria andBselfNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bSelf not between", value1, value2, "bself");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignIsNull() {
            addCriterion("bProxyForeign is null");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignIsNotNull() {
            addCriterion("bProxyForeign is not null");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignEqualTo(Boolean value) {
            addCriterion("bProxyForeign =", value, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignNotEqualTo(Boolean value) {
            addCriterion("bProxyForeign <>", value, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignGreaterThan(Boolean value) {
            addCriterion("bProxyForeign >", value, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bProxyForeign >=", value, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignLessThan(Boolean value) {
            addCriterion("bProxyForeign <", value, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignLessThanOrEqualTo(Boolean value) {
            addCriterion("bProxyForeign <=", value, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignIn(List<Boolean> values) {
            addCriterion("bProxyForeign in", values, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignNotIn(List<Boolean> values) {
            addCriterion("bProxyForeign not in", values, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignBetween(Boolean value1, Boolean value2) {
            addCriterion("bProxyForeign between", value1, value2, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBproxyforeignNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bProxyForeign not between", value1, value2, "bproxyforeign");
            return (Criteria) this;
        }

        public Criteria andBsaleIsNull() {
            addCriterion("bSale is null");
            return (Criteria) this;
        }

        public Criteria andBsaleIsNotNull() {
            addCriterion("bSale is not null");
            return (Criteria) this;
        }

        public Criteria andBsaleEqualTo(Boolean value) {
            addCriterion("bSale =", value, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleNotEqualTo(Boolean value) {
            addCriterion("bSale <>", value, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleGreaterThan(Boolean value) {
            addCriterion("bSale >", value, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bSale >=", value, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleLessThan(Boolean value) {
            addCriterion("bSale <", value, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleLessThanOrEqualTo(Boolean value) {
            addCriterion("bSale <=", value, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleIn(List<Boolean> values) {
            addCriterion("bSale in", values, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleNotIn(List<Boolean> values) {
            addCriterion("bSale not in", values, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleBetween(Boolean value1, Boolean value2) {
            addCriterion("bSale between", value1, value2, "bsale");
            return (Criteria) this;
        }

        public Criteria andBsaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bSale not between", value1, value2, "bsale");
            return (Criteria) this;
        }

        public Criteria andBfree1IsNull() {
            addCriterion("bFree1 is null");
            return (Criteria) this;
        }

        public Criteria andBfree1IsNotNull() {
            addCriterion("bFree1 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree1EqualTo(Boolean value) {
            addCriterion("bFree1 =", value, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1NotEqualTo(Boolean value) {
            addCriterion("bFree1 <>", value, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1GreaterThan(Boolean value) {
            addCriterion("bFree1 >", value, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree1 >=", value, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1LessThan(Boolean value) {
            addCriterion("bFree1 <", value, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree1 <=", value, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1In(List<Boolean> values) {
            addCriterion("bFree1 in", values, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1NotIn(List<Boolean> values) {
            addCriterion("bFree1 not in", values, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1Between(Boolean value1, Boolean value2) {
            addCriterion("bFree1 between", value1, value2, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree1NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree1 not between", value1, value2, "bfree1");
            return (Criteria) this;
        }

        public Criteria andBfree2IsNull() {
            addCriterion("bFree2 is null");
            return (Criteria) this;
        }

        public Criteria andBfree2IsNotNull() {
            addCriterion("bFree2 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree2EqualTo(Boolean value) {
            addCriterion("bFree2 =", value, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2NotEqualTo(Boolean value) {
            addCriterion("bFree2 <>", value, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2GreaterThan(Boolean value) {
            addCriterion("bFree2 >", value, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree2 >=", value, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2LessThan(Boolean value) {
            addCriterion("bFree2 <", value, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree2 <=", value, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2In(List<Boolean> values) {
            addCriterion("bFree2 in", values, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2NotIn(List<Boolean> values) {
            addCriterion("bFree2 not in", values, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2Between(Boolean value1, Boolean value2) {
            addCriterion("bFree2 between", value1, value2, "bfree2");
            return (Criteria) this;
        }

        public Criteria andBfree2NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree2 not between", value1, value2, "bfree2");
            return (Criteria) this;
        }

        public Criteria andDcreatedateIsNull() {
            addCriterion("dCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andDcreatedateIsNotNull() {
            addCriterion("dCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andDcreatedateEqualTo(Date value) {
            addCriterion("dCreateDate =", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotEqualTo(Date value) {
            addCriterion("dCreateDate <>", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateGreaterThan(Date value) {
            addCriterion("dCreateDate >", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("dCreateDate >=", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateLessThan(Date value) {
            addCriterion("dCreateDate <", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateLessThanOrEqualTo(Date value) {
            addCriterion("dCreateDate <=", value, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateIn(List<Date> values) {
            addCriterion("dCreateDate in", values, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotIn(List<Date> values) {
            addCriterion("dCreateDate not in", values, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateBetween(Date value1, Date value2) {
            addCriterion("dCreateDate between", value1, value2, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andDcreatedateNotBetween(Date value1, Date value2) {
            addCriterion("dCreateDate not between", value1, value2, "dcreatedate");
            return (Criteria) this;
        }

        public Criteria andImodifycountsIsNull() {
            addCriterion("iModifyCounts is null");
            return (Criteria) this;
        }

        public Criteria andImodifycountsIsNotNull() {
            addCriterion("iModifyCounts is not null");
            return (Criteria) this;
        }

        public Criteria andImodifycountsEqualTo(Short value) {
            addCriterion("iModifyCounts =", value, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsNotEqualTo(Short value) {
            addCriterion("iModifyCounts <>", value, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsGreaterThan(Short value) {
            addCriterion("iModifyCounts >", value, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsGreaterThanOrEqualTo(Short value) {
            addCriterion("iModifyCounts >=", value, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsLessThan(Short value) {
            addCriterion("iModifyCounts <", value, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsLessThanOrEqualTo(Short value) {
            addCriterion("iModifyCounts <=", value, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsIn(List<Short> values) {
            addCriterion("iModifyCounts in", values, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsNotIn(List<Short> values) {
            addCriterion("iModifyCounts not in", values, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsBetween(Short value1, Short value2) {
            addCriterion("iModifyCounts between", value1, value2, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andImodifycountsNotBetween(Short value1, Short value2) {
            addCriterion("iModifyCounts not between", value1, value2, "imodifycounts");
            return (Criteria) this;
        }

        public Criteria andClastmodifierIsNull() {
            addCriterion("cLastModifier is null");
            return (Criteria) this;
        }

        public Criteria andClastmodifierIsNotNull() {
            addCriterion("cLastModifier is not null");
            return (Criteria) this;
        }

        public Criteria andClastmodifierEqualTo(String value) {
            addCriterion("cLastModifier =", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierNotEqualTo(String value) {
            addCriterion("cLastModifier <>", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierGreaterThan(String value) {
            addCriterion("cLastModifier >", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierGreaterThanOrEqualTo(String value) {
            addCriterion("cLastModifier >=", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierLessThan(String value) {
            addCriterion("cLastModifier <", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierLessThanOrEqualTo(String value) {
            addCriterion("cLastModifier <=", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierLike(String value) {
            addCriterion("cLastModifier like", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierNotLike(String value) {
            addCriterion("cLastModifier not like", value, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierIn(List<String> values) {
            addCriterion("cLastModifier in", values, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierNotIn(List<String> values) {
            addCriterion("cLastModifier not in", values, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierBetween(String value1, String value2) {
            addCriterion("cLastModifier between", value1, value2, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andClastmodifierNotBetween(String value1, String value2) {
            addCriterion("cLastModifier not between", value1, value2, "clastmodifier");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateIsNull() {
            addCriterion("dLastModifyDate is null");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateIsNotNull() {
            addCriterion("dLastModifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateEqualTo(Date value) {
            addCriterion("dLastModifyDate =", value, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateNotEqualTo(Date value) {
            addCriterion("dLastModifyDate <>", value, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateGreaterThan(Date value) {
            addCriterion("dLastModifyDate >", value, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateGreaterThanOrEqualTo(Date value) {
            addCriterion("dLastModifyDate >=", value, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateLessThan(Date value) {
            addCriterion("dLastModifyDate <", value, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateLessThanOrEqualTo(Date value) {
            addCriterion("dLastModifyDate <=", value, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateIn(List<Date> values) {
            addCriterion("dLastModifyDate in", values, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateNotIn(List<Date> values) {
            addCriterion("dLastModifyDate not in", values, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateBetween(Date value1, Date value2) {
            addCriterion("dLastModifyDate between", value1, value2, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andDlastmodifydateNotBetween(Date value1, Date value2) {
            addCriterion("dLastModifyDate not between", value1, value2, "dlastmodifydate");
            return (Criteria) this;
        }

        public Criteria andBmesisreadIsNull() {
            addCriterion("bMesIsRead is null");
            return (Criteria) this;
        }

        public Criteria andBmesisreadIsNotNull() {
            addCriterion("bMesIsRead is not null");
            return (Criteria) this;
        }

        public Criteria andBmesisreadEqualTo(Boolean value) {
            addCriterion("bMesIsRead =", value, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadNotEqualTo(Boolean value) {
            addCriterion("bMesIsRead <>", value, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadGreaterThan(Boolean value) {
            addCriterion("bMesIsRead >", value, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bMesIsRead >=", value, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadLessThan(Boolean value) {
            addCriterion("bMesIsRead <", value, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadLessThanOrEqualTo(Boolean value) {
            addCriterion("bMesIsRead <=", value, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadIn(List<Boolean> values) {
            addCriterion("bMesIsRead in", values, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadNotIn(List<Boolean> values) {
            addCriterion("bMesIsRead not in", values, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadBetween(Boolean value1, Boolean value2) {
            addCriterion("bMesIsRead between", value1, value2, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andBmesisreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bMesIsRead not between", value1, value2, "bmesisread");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateIsNull() {
            addCriterion("dMesReadDate is null");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateIsNotNull() {
            addCriterion("dMesReadDate is not null");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateEqualTo(Date value) {
            addCriterion("dMesReadDate =", value, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateNotEqualTo(Date value) {
            addCriterion("dMesReadDate <>", value, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateGreaterThan(Date value) {
            addCriterion("dMesReadDate >", value, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateGreaterThanOrEqualTo(Date value) {
            addCriterion("dMesReadDate >=", value, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateLessThan(Date value) {
            addCriterion("dMesReadDate <", value, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateLessThanOrEqualTo(Date value) {
            addCriterion("dMesReadDate <=", value, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateIn(List<Date> values) {
            addCriterion("dMesReadDate in", values, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateNotIn(List<Date> values) {
            addCriterion("dMesReadDate not in", values, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateBetween(Date value1, Date value2) {
            addCriterion("dMesReadDate between", value1, value2, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andDmesreaddateNotBetween(Date value1, Date value2) {
            addCriterion("dMesReadDate not between", value1, value2, "dmesreaddate");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1IsNull() {
            addCriterion("cInvDefine1 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1IsNotNull() {
            addCriterion("cInvDefine1 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1EqualTo(String value) {
            addCriterion("cInvDefine1 =", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1NotEqualTo(String value) {
            addCriterion("cInvDefine1 <>", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1GreaterThan(String value) {
            addCriterion("cInvDefine1 >", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine1 >=", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1LessThan(String value) {
            addCriterion("cInvDefine1 <", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine1 <=", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1Like(String value) {
            addCriterion("cInvDefine1 like", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1NotLike(String value) {
            addCriterion("cInvDefine1 not like", value, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1In(List<String> values) {
            addCriterion("cInvDefine1 in", values, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1NotIn(List<String> values) {
            addCriterion("cInvDefine1 not in", values, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1Between(String value1, String value2) {
            addCriterion("cInvDefine1 between", value1, value2, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine1NotBetween(String value1, String value2) {
            addCriterion("cInvDefine1 not between", value1, value2, "cinvdefine1");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2IsNull() {
            addCriterion("cInvDefine2 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2IsNotNull() {
            addCriterion("cInvDefine2 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2EqualTo(String value) {
            addCriterion("cInvDefine2 =", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2NotEqualTo(String value) {
            addCriterion("cInvDefine2 <>", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2GreaterThan(String value) {
            addCriterion("cInvDefine2 >", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine2 >=", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2LessThan(String value) {
            addCriterion("cInvDefine2 <", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine2 <=", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2Like(String value) {
            addCriterion("cInvDefine2 like", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2NotLike(String value) {
            addCriterion("cInvDefine2 not like", value, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2In(List<String> values) {
            addCriterion("cInvDefine2 in", values, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2NotIn(List<String> values) {
            addCriterion("cInvDefine2 not in", values, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2Between(String value1, String value2) {
            addCriterion("cInvDefine2 between", value1, value2, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine2NotBetween(String value1, String value2) {
            addCriterion("cInvDefine2 not between", value1, value2, "cinvdefine2");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3IsNull() {
            addCriterion("cInvDefine3 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3IsNotNull() {
            addCriterion("cInvDefine3 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3EqualTo(String value) {
            addCriterion("cInvDefine3 =", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3NotEqualTo(String value) {
            addCriterion("cInvDefine3 <>", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3GreaterThan(String value) {
            addCriterion("cInvDefine3 >", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine3 >=", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3LessThan(String value) {
            addCriterion("cInvDefine3 <", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine3 <=", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3Like(String value) {
            addCriterion("cInvDefine3 like", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3NotLike(String value) {
            addCriterion("cInvDefine3 not like", value, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3In(List<String> values) {
            addCriterion("cInvDefine3 in", values, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3NotIn(List<String> values) {
            addCriterion("cInvDefine3 not in", values, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3Between(String value1, String value2) {
            addCriterion("cInvDefine3 between", value1, value2, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine3NotBetween(String value1, String value2) {
            addCriterion("cInvDefine3 not between", value1, value2, "cinvdefine3");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4IsNull() {
            addCriterion("cInvDefine4 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4IsNotNull() {
            addCriterion("cInvDefine4 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4EqualTo(String value) {
            addCriterion("cInvDefine4 =", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4NotEqualTo(String value) {
            addCriterion("cInvDefine4 <>", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4GreaterThan(String value) {
            addCriterion("cInvDefine4 >", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine4 >=", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4LessThan(String value) {
            addCriterion("cInvDefine4 <", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine4 <=", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4Like(String value) {
            addCriterion("cInvDefine4 like", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4NotLike(String value) {
            addCriterion("cInvDefine4 not like", value, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4In(List<String> values) {
            addCriterion("cInvDefine4 in", values, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4NotIn(List<String> values) {
            addCriterion("cInvDefine4 not in", values, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4Between(String value1, String value2) {
            addCriterion("cInvDefine4 between", value1, value2, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine4NotBetween(String value1, String value2) {
            addCriterion("cInvDefine4 not between", value1, value2, "cinvdefine4");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5IsNull() {
            addCriterion("cInvDefine5 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5IsNotNull() {
            addCriterion("cInvDefine5 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5EqualTo(String value) {
            addCriterion("cInvDefine5 =", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5NotEqualTo(String value) {
            addCriterion("cInvDefine5 <>", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5GreaterThan(String value) {
            addCriterion("cInvDefine5 >", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine5 >=", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5LessThan(String value) {
            addCriterion("cInvDefine5 <", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine5 <=", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5Like(String value) {
            addCriterion("cInvDefine5 like", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5NotLike(String value) {
            addCriterion("cInvDefine5 not like", value, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5In(List<String> values) {
            addCriterion("cInvDefine5 in", values, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5NotIn(List<String> values) {
            addCriterion("cInvDefine5 not in", values, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5Between(String value1, String value2) {
            addCriterion("cInvDefine5 between", value1, value2, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine5NotBetween(String value1, String value2) {
            addCriterion("cInvDefine5 not between", value1, value2, "cinvdefine5");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6IsNull() {
            addCriterion("cInvDefine6 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6IsNotNull() {
            addCriterion("cInvDefine6 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6EqualTo(String value) {
            addCriterion("cInvDefine6 =", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6NotEqualTo(String value) {
            addCriterion("cInvDefine6 <>", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6GreaterThan(String value) {
            addCriterion("cInvDefine6 >", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine6 >=", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6LessThan(String value) {
            addCriterion("cInvDefine6 <", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine6 <=", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6Like(String value) {
            addCriterion("cInvDefine6 like", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6NotLike(String value) {
            addCriterion("cInvDefine6 not like", value, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6In(List<String> values) {
            addCriterion("cInvDefine6 in", values, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6NotIn(List<String> values) {
            addCriterion("cInvDefine6 not in", values, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6Between(String value1, String value2) {
            addCriterion("cInvDefine6 between", value1, value2, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine6NotBetween(String value1, String value2) {
            addCriterion("cInvDefine6 not between", value1, value2, "cinvdefine6");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7IsNull() {
            addCriterion("cInvDefine7 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7IsNotNull() {
            addCriterion("cInvDefine7 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7EqualTo(String value) {
            addCriterion("cInvDefine7 =", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7NotEqualTo(String value) {
            addCriterion("cInvDefine7 <>", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7GreaterThan(String value) {
            addCriterion("cInvDefine7 >", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine7 >=", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7LessThan(String value) {
            addCriterion("cInvDefine7 <", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine7 <=", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7Like(String value) {
            addCriterion("cInvDefine7 like", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7NotLike(String value) {
            addCriterion("cInvDefine7 not like", value, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7In(List<String> values) {
            addCriterion("cInvDefine7 in", values, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7NotIn(List<String> values) {
            addCriterion("cInvDefine7 not in", values, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7Between(String value1, String value2) {
            addCriterion("cInvDefine7 between", value1, value2, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine7NotBetween(String value1, String value2) {
            addCriterion("cInvDefine7 not between", value1, value2, "cinvdefine7");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8IsNull() {
            addCriterion("cInvDefine8 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8IsNotNull() {
            addCriterion("cInvDefine8 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8EqualTo(String value) {
            addCriterion("cInvDefine8 =", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8NotEqualTo(String value) {
            addCriterion("cInvDefine8 <>", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8GreaterThan(String value) {
            addCriterion("cInvDefine8 >", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine8 >=", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8LessThan(String value) {
            addCriterion("cInvDefine8 <", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine8 <=", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8Like(String value) {
            addCriterion("cInvDefine8 like", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8NotLike(String value) {
            addCriterion("cInvDefine8 not like", value, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8In(List<String> values) {
            addCriterion("cInvDefine8 in", values, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8NotIn(List<String> values) {
            addCriterion("cInvDefine8 not in", values, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8Between(String value1, String value2) {
            addCriterion("cInvDefine8 between", value1, value2, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine8NotBetween(String value1, String value2) {
            addCriterion("cInvDefine8 not between", value1, value2, "cinvdefine8");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9IsNull() {
            addCriterion("cInvDefine9 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9IsNotNull() {
            addCriterion("cInvDefine9 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9EqualTo(String value) {
            addCriterion("cInvDefine9 =", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9NotEqualTo(String value) {
            addCriterion("cInvDefine9 <>", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9GreaterThan(String value) {
            addCriterion("cInvDefine9 >", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine9 >=", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9LessThan(String value) {
            addCriterion("cInvDefine9 <", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine9 <=", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9Like(String value) {
            addCriterion("cInvDefine9 like", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9NotLike(String value) {
            addCriterion("cInvDefine9 not like", value, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9In(List<String> values) {
            addCriterion("cInvDefine9 in", values, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9NotIn(List<String> values) {
            addCriterion("cInvDefine9 not in", values, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9Between(String value1, String value2) {
            addCriterion("cInvDefine9 between", value1, value2, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine9NotBetween(String value1, String value2) {
            addCriterion("cInvDefine9 not between", value1, value2, "cinvdefine9");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10IsNull() {
            addCriterion("cInvDefine10 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10IsNotNull() {
            addCriterion("cInvDefine10 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10EqualTo(String value) {
            addCriterion("cInvDefine10 =", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10NotEqualTo(String value) {
            addCriterion("cInvDefine10 <>", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10GreaterThan(String value) {
            addCriterion("cInvDefine10 >", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10GreaterThanOrEqualTo(String value) {
            addCriterion("cInvDefine10 >=", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10LessThan(String value) {
            addCriterion("cInvDefine10 <", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10LessThanOrEqualTo(String value) {
            addCriterion("cInvDefine10 <=", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10Like(String value) {
            addCriterion("cInvDefine10 like", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10NotLike(String value) {
            addCriterion("cInvDefine10 not like", value, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10In(List<String> values) {
            addCriterion("cInvDefine10 in", values, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10NotIn(List<String> values) {
            addCriterion("cInvDefine10 not in", values, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10Between(String value1, String value2) {
            addCriterion("cInvDefine10 between", value1, value2, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine10NotBetween(String value1, String value2) {
            addCriterion("cInvDefine10 not between", value1, value2, "cinvdefine10");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11IsNull() {
            addCriterion("cInvDefine11 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11IsNotNull() {
            addCriterion("cInvDefine11 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11EqualTo(Integer value) {
            addCriterion("cInvDefine11 =", value, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11NotEqualTo(Integer value) {
            addCriterion("cInvDefine11 <>", value, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11GreaterThan(Integer value) {
            addCriterion("cInvDefine11 >", value, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11GreaterThanOrEqualTo(Integer value) {
            addCriterion("cInvDefine11 >=", value, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11LessThan(Integer value) {
            addCriterion("cInvDefine11 <", value, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11LessThanOrEqualTo(Integer value) {
            addCriterion("cInvDefine11 <=", value, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11In(List<Integer> values) {
            addCriterion("cInvDefine11 in", values, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11NotIn(List<Integer> values) {
            addCriterion("cInvDefine11 not in", values, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11Between(Integer value1, Integer value2) {
            addCriterion("cInvDefine11 between", value1, value2, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine11NotBetween(Integer value1, Integer value2) {
            addCriterion("cInvDefine11 not between", value1, value2, "cinvdefine11");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12IsNull() {
            addCriterion("cInvDefine12 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12IsNotNull() {
            addCriterion("cInvDefine12 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12EqualTo(Integer value) {
            addCriterion("cInvDefine12 =", value, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12NotEqualTo(Integer value) {
            addCriterion("cInvDefine12 <>", value, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12GreaterThan(Integer value) {
            addCriterion("cInvDefine12 >", value, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12GreaterThanOrEqualTo(Integer value) {
            addCriterion("cInvDefine12 >=", value, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12LessThan(Integer value) {
            addCriterion("cInvDefine12 <", value, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12LessThanOrEqualTo(Integer value) {
            addCriterion("cInvDefine12 <=", value, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12In(List<Integer> values) {
            addCriterion("cInvDefine12 in", values, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12NotIn(List<Integer> values) {
            addCriterion("cInvDefine12 not in", values, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12Between(Integer value1, Integer value2) {
            addCriterion("cInvDefine12 between", value1, value2, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine12NotBetween(Integer value1, Integer value2) {
            addCriterion("cInvDefine12 not between", value1, value2, "cinvdefine12");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13IsNull() {
            addCriterion("cInvDefine13 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13IsNotNull() {
            addCriterion("cInvDefine13 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13EqualTo(Double value) {
            addCriterion("cInvDefine13 =", value, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13NotEqualTo(Double value) {
            addCriterion("cInvDefine13 <>", value, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13GreaterThan(Double value) {
            addCriterion("cInvDefine13 >", value, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13GreaterThanOrEqualTo(Double value) {
            addCriterion("cInvDefine13 >=", value, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13LessThan(Double value) {
            addCriterion("cInvDefine13 <", value, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13LessThanOrEqualTo(Double value) {
            addCriterion("cInvDefine13 <=", value, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13In(List<Double> values) {
            addCriterion("cInvDefine13 in", values, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13NotIn(List<Double> values) {
            addCriterion("cInvDefine13 not in", values, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13Between(Double value1, Double value2) {
            addCriterion("cInvDefine13 between", value1, value2, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine13NotBetween(Double value1, Double value2) {
            addCriterion("cInvDefine13 not between", value1, value2, "cinvdefine13");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14IsNull() {
            addCriterion("cInvDefine14 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14IsNotNull() {
            addCriterion("cInvDefine14 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14EqualTo(Double value) {
            addCriterion("cInvDefine14 =", value, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14NotEqualTo(Double value) {
            addCriterion("cInvDefine14 <>", value, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14GreaterThan(Double value) {
            addCriterion("cInvDefine14 >", value, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14GreaterThanOrEqualTo(Double value) {
            addCriterion("cInvDefine14 >=", value, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14LessThan(Double value) {
            addCriterion("cInvDefine14 <", value, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14LessThanOrEqualTo(Double value) {
            addCriterion("cInvDefine14 <=", value, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14In(List<Double> values) {
            addCriterion("cInvDefine14 in", values, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14NotIn(List<Double> values) {
            addCriterion("cInvDefine14 not in", values, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14Between(Double value1, Double value2) {
            addCriterion("cInvDefine14 between", value1, value2, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine14NotBetween(Double value1, Double value2) {
            addCriterion("cInvDefine14 not between", value1, value2, "cinvdefine14");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15IsNull() {
            addCriterion("cInvDefine15 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15IsNotNull() {
            addCriterion("cInvDefine15 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15EqualTo(Date value) {
            addCriterion("cInvDefine15 =", value, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15NotEqualTo(Date value) {
            addCriterion("cInvDefine15 <>", value, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15GreaterThan(Date value) {
            addCriterion("cInvDefine15 >", value, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15GreaterThanOrEqualTo(Date value) {
            addCriterion("cInvDefine15 >=", value, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15LessThan(Date value) {
            addCriterion("cInvDefine15 <", value, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15LessThanOrEqualTo(Date value) {
            addCriterion("cInvDefine15 <=", value, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15In(List<Date> values) {
            addCriterion("cInvDefine15 in", values, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15NotIn(List<Date> values) {
            addCriterion("cInvDefine15 not in", values, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15Between(Date value1, Date value2) {
            addCriterion("cInvDefine15 between", value1, value2, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine15NotBetween(Date value1, Date value2) {
            addCriterion("cInvDefine15 not between", value1, value2, "cinvdefine15");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16IsNull() {
            addCriterion("cInvDefine16 is null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16IsNotNull() {
            addCriterion("cInvDefine16 is not null");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16EqualTo(Date value) {
            addCriterion("cInvDefine16 =", value, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16NotEqualTo(Date value) {
            addCriterion("cInvDefine16 <>", value, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16GreaterThan(Date value) {
            addCriterion("cInvDefine16 >", value, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16GreaterThanOrEqualTo(Date value) {
            addCriterion("cInvDefine16 >=", value, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16LessThan(Date value) {
            addCriterion("cInvDefine16 <", value, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16LessThanOrEqualTo(Date value) {
            addCriterion("cInvDefine16 <=", value, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16In(List<Date> values) {
            addCriterion("cInvDefine16 in", values, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16NotIn(List<Date> values) {
            addCriterion("cInvDefine16 not in", values, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16Between(Date value1, Date value2) {
            addCriterion("cInvDefine16 between", value1, value2, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvdefine16NotBetween(Date value1, Date value2) {
            addCriterion("cInvDefine16 not between", value1, value2, "cinvdefine16");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeIsNull() {
            addCriterion("cInvMnemCode is null");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeIsNotNull() {
            addCriterion("cInvMnemCode is not null");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeEqualTo(String value) {
            addCriterion("cInvMnemCode =", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeNotEqualTo(String value) {
            addCriterion("cInvMnemCode <>", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeGreaterThan(String value) {
            addCriterion("cInvMnemCode >", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cInvMnemCode >=", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeLessThan(String value) {
            addCriterion("cInvMnemCode <", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeLessThanOrEqualTo(String value) {
            addCriterion("cInvMnemCode <=", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeLike(String value) {
            addCriterion("cInvMnemCode like", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeNotLike(String value) {
            addCriterion("cInvMnemCode not like", value, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeIn(List<String> values) {
            addCriterion("cInvMnemCode in", values, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeNotIn(List<String> values) {
            addCriterion("cInvMnemCode not in", values, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeBetween(String value1, String value2) {
            addCriterion("cInvMnemCode between", value1, value2, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andCinvmnemcodeNotBetween(String value1, String value2) {
            addCriterion("cInvMnemCode not between", value1, value2, "cinvmnemcode");
            return (Criteria) this;
        }

        public Criteria andImassdateIsNull() {
            addCriterion("iMassDate is null");
            return (Criteria) this;
        }

        public Criteria andImassdateIsNotNull() {
            addCriterion("iMassDate is not null");
            return (Criteria) this;
        }

        public Criteria andImassdateEqualTo(Short value) {
            addCriterion("iMassDate =", value, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateNotEqualTo(Short value) {
            addCriterion("iMassDate <>", value, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateGreaterThan(Short value) {
            addCriterion("iMassDate >", value, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateGreaterThanOrEqualTo(Short value) {
            addCriterion("iMassDate >=", value, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateLessThan(Short value) {
            addCriterion("iMassDate <", value, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateLessThanOrEqualTo(Short value) {
            addCriterion("iMassDate <=", value, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateIn(List<Short> values) {
            addCriterion("iMassDate in", values, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateNotIn(List<Short> values) {
            addCriterion("iMassDate not in", values, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateBetween(Short value1, Short value2) {
            addCriterion("iMassDate between", value1, value2, "imassdate");
            return (Criteria) this;
        }

        public Criteria andImassdateNotBetween(Short value1, Short value2) {
            addCriterion("iMassDate not between", value1, value2, "imassdate");
            return (Criteria) this;
        }

        public Criteria andCmassunitIsNull() {
            addCriterion("cMassUnit is null");
            return (Criteria) this;
        }

        public Criteria andCmassunitIsNotNull() {
            addCriterion("cMassUnit is not null");
            return (Criteria) this;
        }

        public Criteria andCmassunitEqualTo(Short value) {
            addCriterion("cMassUnit =", value, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitNotEqualTo(Short value) {
            addCriterion("cMassUnit <>", value, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitGreaterThan(Short value) {
            addCriterion("cMassUnit >", value, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitGreaterThanOrEqualTo(Short value) {
            addCriterion("cMassUnit >=", value, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitLessThan(Short value) {
            addCriterion("cMassUnit <", value, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitLessThanOrEqualTo(Short value) {
            addCriterion("cMassUnit <=", value, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitIn(List<Short> values) {
            addCriterion("cMassUnit in", values, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitNotIn(List<Short> values) {
            addCriterion("cMassUnit not in", values, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitBetween(Short value1, Short value2) {
            addCriterion("cMassUnit between", value1, value2, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andCmassunitNotBetween(Short value1, Short value2) {
            addCriterion("cMassUnit not between", value1, value2, "cmassunit");
            return (Criteria) this;
        }

        public Criteria andBfree3IsNull() {
            addCriterion("bFree3 is null");
            return (Criteria) this;
        }

        public Criteria andBfree3IsNotNull() {
            addCriterion("bFree3 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree3EqualTo(Boolean value) {
            addCriterion("bFree3 =", value, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3NotEqualTo(Boolean value) {
            addCriterion("bFree3 <>", value, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3GreaterThan(Boolean value) {
            addCriterion("bFree3 >", value, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree3 >=", value, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3LessThan(Boolean value) {
            addCriterion("bFree3 <", value, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree3 <=", value, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3In(List<Boolean> values) {
            addCriterion("bFree3 in", values, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3NotIn(List<Boolean> values) {
            addCriterion("bFree3 not in", values, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3Between(Boolean value1, Boolean value2) {
            addCriterion("bFree3 between", value1, value2, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree3NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree3 not between", value1, value2, "bfree3");
            return (Criteria) this;
        }

        public Criteria andBfree4IsNull() {
            addCriterion("bFree4 is null");
            return (Criteria) this;
        }

        public Criteria andBfree4IsNotNull() {
            addCriterion("bFree4 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree4EqualTo(Boolean value) {
            addCriterion("bFree4 =", value, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4NotEqualTo(Boolean value) {
            addCriterion("bFree4 <>", value, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4GreaterThan(Boolean value) {
            addCriterion("bFree4 >", value, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree4 >=", value, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4LessThan(Boolean value) {
            addCriterion("bFree4 <", value, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree4 <=", value, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4In(List<Boolean> values) {
            addCriterion("bFree4 in", values, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4NotIn(List<Boolean> values) {
            addCriterion("bFree4 not in", values, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4Between(Boolean value1, Boolean value2) {
            addCriterion("bFree4 between", value1, value2, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree4NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree4 not between", value1, value2, "bfree4");
            return (Criteria) this;
        }

        public Criteria andBfree5IsNull() {
            addCriterion("bFree5 is null");
            return (Criteria) this;
        }

        public Criteria andBfree5IsNotNull() {
            addCriterion("bFree5 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree5EqualTo(Boolean value) {
            addCriterion("bFree5 =", value, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5NotEqualTo(Boolean value) {
            addCriterion("bFree5 <>", value, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5GreaterThan(Boolean value) {
            addCriterion("bFree5 >", value, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree5 >=", value, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5LessThan(Boolean value) {
            addCriterion("bFree5 <", value, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree5 <=", value, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5In(List<Boolean> values) {
            addCriterion("bFree5 in", values, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5NotIn(List<Boolean> values) {
            addCriterion("bFree5 not in", values, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5Between(Boolean value1, Boolean value2) {
            addCriterion("bFree5 between", value1, value2, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree5NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree5 not between", value1, value2, "bfree5");
            return (Criteria) this;
        }

        public Criteria andBfree6IsNull() {
            addCriterion("bFree6 is null");
            return (Criteria) this;
        }

        public Criteria andBfree6IsNotNull() {
            addCriterion("bFree6 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree6EqualTo(Boolean value) {
            addCriterion("bFree6 =", value, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6NotEqualTo(Boolean value) {
            addCriterion("bFree6 <>", value, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6GreaterThan(Boolean value) {
            addCriterion("bFree6 >", value, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree6 >=", value, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6LessThan(Boolean value) {
            addCriterion("bFree6 <", value, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree6 <=", value, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6In(List<Boolean> values) {
            addCriterion("bFree6 in", values, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6NotIn(List<Boolean> values) {
            addCriterion("bFree6 not in", values, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6Between(Boolean value1, Boolean value2) {
            addCriterion("bFree6 between", value1, value2, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree6NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree6 not between", value1, value2, "bfree6");
            return (Criteria) this;
        }

        public Criteria andBfree7IsNull() {
            addCriterion("bFree7 is null");
            return (Criteria) this;
        }

        public Criteria andBfree7IsNotNull() {
            addCriterion("bFree7 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree7EqualTo(Boolean value) {
            addCriterion("bFree7 =", value, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7NotEqualTo(Boolean value) {
            addCriterion("bFree7 <>", value, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7GreaterThan(Boolean value) {
            addCriterion("bFree7 >", value, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree7 >=", value, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7LessThan(Boolean value) {
            addCriterion("bFree7 <", value, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree7 <=", value, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7In(List<Boolean> values) {
            addCriterion("bFree7 in", values, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7NotIn(List<Boolean> values) {
            addCriterion("bFree7 not in", values, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7Between(Boolean value1, Boolean value2) {
            addCriterion("bFree7 between", value1, value2, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree7NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree7 not between", value1, value2, "bfree7");
            return (Criteria) this;
        }

        public Criteria andBfree8IsNull() {
            addCriterion("bFree8 is null");
            return (Criteria) this;
        }

        public Criteria andBfree8IsNotNull() {
            addCriterion("bFree8 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree8EqualTo(Boolean value) {
            addCriterion("bFree8 =", value, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8NotEqualTo(Boolean value) {
            addCriterion("bFree8 <>", value, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8GreaterThan(Boolean value) {
            addCriterion("bFree8 >", value, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree8 >=", value, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8LessThan(Boolean value) {
            addCriterion("bFree8 <", value, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree8 <=", value, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8In(List<Boolean> values) {
            addCriterion("bFree8 in", values, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8NotIn(List<Boolean> values) {
            addCriterion("bFree8 not in", values, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8Between(Boolean value1, Boolean value2) {
            addCriterion("bFree8 between", value1, value2, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree8NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree8 not between", value1, value2, "bfree8");
            return (Criteria) this;
        }

        public Criteria andBfree9IsNull() {
            addCriterion("bFree9 is null");
            return (Criteria) this;
        }

        public Criteria andBfree9IsNotNull() {
            addCriterion("bFree9 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree9EqualTo(Boolean value) {
            addCriterion("bFree9 =", value, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9NotEqualTo(Boolean value) {
            addCriterion("bFree9 <>", value, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9GreaterThan(Boolean value) {
            addCriterion("bFree9 >", value, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree9 >=", value, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9LessThan(Boolean value) {
            addCriterion("bFree9 <", value, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree9 <=", value, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9In(List<Boolean> values) {
            addCriterion("bFree9 in", values, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9NotIn(List<Boolean> values) {
            addCriterion("bFree9 not in", values, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9Between(Boolean value1, Boolean value2) {
            addCriterion("bFree9 between", value1, value2, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree9NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree9 not between", value1, value2, "bfree9");
            return (Criteria) this;
        }

        public Criteria andBfree10IsNull() {
            addCriterion("bFree10 is null");
            return (Criteria) this;
        }

        public Criteria andBfree10IsNotNull() {
            addCriterion("bFree10 is not null");
            return (Criteria) this;
        }

        public Criteria andBfree10EqualTo(Boolean value) {
            addCriterion("bFree10 =", value, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10NotEqualTo(Boolean value) {
            addCriterion("bFree10 <>", value, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10GreaterThan(Boolean value) {
            addCriterion("bFree10 >", value, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10GreaterThanOrEqualTo(Boolean value) {
            addCriterion("bFree10 >=", value, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10LessThan(Boolean value) {
            addCriterion("bFree10 <", value, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10LessThanOrEqualTo(Boolean value) {
            addCriterion("bFree10 <=", value, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10In(List<Boolean> values) {
            addCriterion("bFree10 in", values, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10NotIn(List<Boolean> values) {
            addCriterion("bFree10 not in", values, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10Between(Boolean value1, Boolean value2) {
            addCriterion("bFree10 between", value1, value2, "bfree10");
            return (Criteria) this;
        }

        public Criteria andBfree10NotBetween(Boolean value1, Boolean value2) {
            addCriterion("bFree10 not between", value1, value2, "bfree10");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}