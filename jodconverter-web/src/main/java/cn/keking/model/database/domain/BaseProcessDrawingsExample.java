package cn.keking.model.database.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseProcessDrawingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseProcessDrawingsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
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

        public Criteria andCiinvaddcodeIsNull() {
            addCriterion("cIInvAddCode is null");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeIsNotNull() {
            addCriterion("cIInvAddCode is not null");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeEqualTo(String value) {
            addCriterion("cIInvAddCode =", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeNotEqualTo(String value) {
            addCriterion("cIInvAddCode <>", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeGreaterThan(String value) {
            addCriterion("cIInvAddCode >", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cIInvAddCode >=", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeLessThan(String value) {
            addCriterion("cIInvAddCode <", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeLessThanOrEqualTo(String value) {
            addCriterion("cIInvAddCode <=", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeLike(String value) {
            addCriterion("cIInvAddCode like", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeNotLike(String value) {
            addCriterion("cIInvAddCode not like", value, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeIn(List<String> values) {
            addCriterion("cIInvAddCode in", values, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeNotIn(List<String> values) {
            addCriterion("cIInvAddCode not in", values, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeBetween(String value1, String value2) {
            addCriterion("cIInvAddCode between", value1, value2, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvaddcodeNotBetween(String value1, String value2) {
            addCriterion("cIInvAddCode not between", value1, value2, "ciinvaddcode");
            return (Criteria) this;
        }

        public Criteria andCiinvnameIsNull() {
            addCriterion("cIInvName is null");
            return (Criteria) this;
        }

        public Criteria andCiinvnameIsNotNull() {
            addCriterion("cIInvName is not null");
            return (Criteria) this;
        }

        public Criteria andCiinvnameEqualTo(String value) {
            addCriterion("cIInvName =", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameNotEqualTo(String value) {
            addCriterion("cIInvName <>", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameGreaterThan(String value) {
            addCriterion("cIInvName >", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameGreaterThanOrEqualTo(String value) {
            addCriterion("cIInvName >=", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameLessThan(String value) {
            addCriterion("cIInvName <", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameLessThanOrEqualTo(String value) {
            addCriterion("cIInvName <=", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameLike(String value) {
            addCriterion("cIInvName like", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameNotLike(String value) {
            addCriterion("cIInvName not like", value, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameIn(List<String> values) {
            addCriterion("cIInvName in", values, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameNotIn(List<String> values) {
            addCriterion("cIInvName not in", values, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameBetween(String value1, String value2) {
            addCriterion("cIInvName between", value1, value2, "ciinvname");
            return (Criteria) this;
        }

        public Criteria andCiinvnameNotBetween(String value1, String value2) {
            addCriterion("cIInvName not between", value1, value2, "ciinvname");
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

        public Criteria andDrawingNoIsNull() {
            addCriterion("drawing_no is null");
            return (Criteria) this;
        }

        public Criteria andDrawingNoIsNotNull() {
            addCriterion("drawing_no is not null");
            return (Criteria) this;
        }

        public Criteria andDrawingNoEqualTo(String value) {
            addCriterion("drawing_no =", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoNotEqualTo(String value) {
            addCriterion("drawing_no <>", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoGreaterThan(String value) {
            addCriterion("drawing_no >", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoGreaterThanOrEqualTo(String value) {
            addCriterion("drawing_no >=", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoLessThan(String value) {
            addCriterion("drawing_no <", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoLessThanOrEqualTo(String value) {
            addCriterion("drawing_no <=", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoLike(String value) {
            addCriterion("drawing_no like", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoNotLike(String value) {
            addCriterion("drawing_no not like", value, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoIn(List<String> values) {
            addCriterion("drawing_no in", values, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoNotIn(List<String> values) {
            addCriterion("drawing_no not in", values, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoBetween(String value1, String value2) {
            addCriterion("drawing_no between", value1, value2, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andDrawingNoNotBetween(String value1, String value2) {
            addCriterion("drawing_no not between", value1, value2, "drawingNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNull() {
            addCriterion("version_no is null");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNotNull() {
            addCriterion("version_no is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNoEqualTo(String value) {
            addCriterion("version_no =", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotEqualTo(String value) {
            addCriterion("version_no <>", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThan(String value) {
            addCriterion("version_no >", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThanOrEqualTo(String value) {
            addCriterion("version_no >=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThan(String value) {
            addCriterion("version_no <", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThanOrEqualTo(String value) {
            addCriterion("version_no <=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLike(String value) {
            addCriterion("version_no like", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotLike(String value) {
            addCriterion("version_no not like", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoIn(List<String> values) {
            addCriterion("version_no in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotIn(List<String> values) {
            addCriterion("version_no not in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoBetween(String value1, String value2) {
            addCriterion("version_no between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotBetween(String value1, String value2) {
            addCriterion("version_no not between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andIsDrawingIsNull() {
            addCriterion("is_drawing is null");
            return (Criteria) this;
        }

        public Criteria andIsDrawingIsNotNull() {
            addCriterion("is_drawing is not null");
            return (Criteria) this;
        }

        public Criteria andIsDrawingEqualTo(Integer value) {
            addCriterion("is_drawing =", value, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingNotEqualTo(Integer value) {
            addCriterion("is_drawing <>", value, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingGreaterThan(Integer value) {
            addCriterion("is_drawing >", value, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_drawing >=", value, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingLessThan(Integer value) {
            addCriterion("is_drawing <", value, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingLessThanOrEqualTo(Integer value) {
            addCriterion("is_drawing <=", value, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingIn(List<Integer> values) {
            addCriterion("is_drawing in", values, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingNotIn(List<Integer> values) {
            addCriterion("is_drawing not in", values, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingBetween(Integer value1, Integer value2) {
            addCriterion("is_drawing between", value1, value2, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsDrawingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_drawing not between", value1, value2, "isDrawing");
            return (Criteria) this;
        }

        public Criteria andIsCardIsNull() {
            addCriterion("is_card is null");
            return (Criteria) this;
        }

        public Criteria andIsCardIsNotNull() {
            addCriterion("is_card is not null");
            return (Criteria) this;
        }

        public Criteria andIsCardEqualTo(Integer value) {
            addCriterion("is_card =", value, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardNotEqualTo(Integer value) {
            addCriterion("is_card <>", value, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardGreaterThan(Integer value) {
            addCriterion("is_card >", value, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_card >=", value, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardLessThan(Integer value) {
            addCriterion("is_card <", value, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardLessThanOrEqualTo(Integer value) {
            addCriterion("is_card <=", value, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardIn(List<Integer> values) {
            addCriterion("is_card in", values, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardNotIn(List<Integer> values) {
            addCriterion("is_card not in", values, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardBetween(Integer value1, Integer value2) {
            addCriterion("is_card between", value1, value2, "isCard");
            return (Criteria) this;
        }

        public Criteria andIsCardNotBetween(Integer value1, Integer value2) {
            addCriterion("is_card not between", value1, value2, "isCard");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Integer value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Integer value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Integer value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Integer value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Integer> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Integer> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNull() {
            addCriterion("updater_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNotNull() {
            addCriterion("updater_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdEqualTo(Integer value) {
            addCriterion("updater_id =", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotEqualTo(Integer value) {
            addCriterion("updater_id <>", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThan(Integer value) {
            addCriterion("updater_id >", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("updater_id >=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThan(Integer value) {
            addCriterion("updater_id <", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThanOrEqualTo(Integer value) {
            addCriterion("updater_id <=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIn(List<Integer> values) {
            addCriterion("updater_id in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotIn(List<Integer> values) {
            addCriterion("updater_id not in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdBetween(Integer value1, Integer value2) {
            addCriterion("updater_id between", value1, value2, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("updater_id not between", value1, value2, "updaterId");
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