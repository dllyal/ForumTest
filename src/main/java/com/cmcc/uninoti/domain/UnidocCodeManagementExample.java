package com.cmcc.uninoti.domain;

import java.util.ArrayList;
import java.util.List;

public class UnidocCodeManagementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnidocCodeManagementExample() {
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

        public Criteria andRegIdIsNull() {
            addCriterion("REG_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegIdIsNotNull() {
            addCriterion("REG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegIdEqualTo(Integer value) {
            addCriterion("REG_ID =", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotEqualTo(Integer value) {
            addCriterion("REG_ID <>", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThan(Integer value) {
            addCriterion("REG_ID >", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REG_ID >=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThan(Integer value) {
            addCriterion("REG_ID <", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThanOrEqualTo(Integer value) {
            addCriterion("REG_ID <=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdIn(List<Integer> values) {
            addCriterion("REG_ID in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotIn(List<Integer> values) {
            addCriterion("REG_ID not in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdBetween(Integer value1, Integer value2) {
            addCriterion("REG_ID between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REG_ID not between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andAppCodeIsNull() {
            addCriterion("APP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAppCodeIsNotNull() {
            addCriterion("APP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAppCodeEqualTo(String value) {
            addCriterion("APP_CODE =", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotEqualTo(String value) {
            addCriterion("APP_CODE <>", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeGreaterThan(String value) {
            addCriterion("APP_CODE >", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeGreaterThanOrEqualTo(String value) {
            addCriterion("APP_CODE >=", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLessThan(String value) {
            addCriterion("APP_CODE <", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLessThanOrEqualTo(String value) {
            addCriterion("APP_CODE <=", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLike(String value) {
            addCriterion("APP_CODE like", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotLike(String value) {
            addCriterion("APP_CODE not like", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeIn(List<String> values) {
            addCriterion("APP_CODE in", values, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotIn(List<String> values) {
            addCriterion("APP_CODE not in", values, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeBetween(String value1, String value2) {
            addCriterion("APP_CODE between", value1, value2, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotBetween(String value1, String value2) {
            addCriterion("APP_CODE not between", value1, value2, "appCode");
            return (Criteria) this;
        }

        public Criteria andAccessLevelIsNull() {
            addCriterion("ACCESS_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andAccessLevelIsNotNull() {
            addCriterion("ACCESS_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andAccessLevelEqualTo(String value) {
            addCriterion("ACCESS_LEVEL =", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelNotEqualTo(String value) {
            addCriterion("ACCESS_LEVEL <>", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelGreaterThan(String value) {
            addCriterion("ACCESS_LEVEL >", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESS_LEVEL >=", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelLessThan(String value) {
            addCriterion("ACCESS_LEVEL <", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelLessThanOrEqualTo(String value) {
            addCriterion("ACCESS_LEVEL <=", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelLike(String value) {
            addCriterion("ACCESS_LEVEL like", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelNotLike(String value) {
            addCriterion("ACCESS_LEVEL not like", value, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelIn(List<String> values) {
            addCriterion("ACCESS_LEVEL in", values, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelNotIn(List<String> values) {
            addCriterion("ACCESS_LEVEL not in", values, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelBetween(String value1, String value2) {
            addCriterion("ACCESS_LEVEL between", value1, value2, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessLevelNotBetween(String value1, String value2) {
            addCriterion("ACCESS_LEVEL not between", value1, value2, "accessLevel");
            return (Criteria) this;
        }

        public Criteria andAccessValIsNull() {
            addCriterion("ACCESS_VAL is null");
            return (Criteria) this;
        }

        public Criteria andAccessValIsNotNull() {
            addCriterion("ACCESS_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andAccessValEqualTo(String value) {
            addCriterion("ACCESS_VAL =", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValNotEqualTo(String value) {
            addCriterion("ACCESS_VAL <>", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValGreaterThan(String value) {
            addCriterion("ACCESS_VAL >", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESS_VAL >=", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValLessThan(String value) {
            addCriterion("ACCESS_VAL <", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValLessThanOrEqualTo(String value) {
            addCriterion("ACCESS_VAL <=", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValLike(String value) {
            addCriterion("ACCESS_VAL like", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValNotLike(String value) {
            addCriterion("ACCESS_VAL not like", value, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValIn(List<String> values) {
            addCriterion("ACCESS_VAL in", values, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValNotIn(List<String> values) {
            addCriterion("ACCESS_VAL not in", values, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValBetween(String value1, String value2) {
            addCriterion("ACCESS_VAL between", value1, value2, "accessVal");
            return (Criteria) this;
        }

        public Criteria andAccessValNotBetween(String value1, String value2) {
            addCriterion("ACCESS_VAL not between", value1, value2, "accessVal");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("EXT_1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("EXT_1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("EXT_1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("EXT_1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("EXT_1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("EXT_1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("EXT_1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("EXT_1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("EXT_1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("EXT_1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("EXT_1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("EXT_1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("EXT_1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("EXT_2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("EXT_2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("EXT_2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("EXT_2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("EXT_2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("EXT_2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("EXT_2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("EXT_2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("EXT_2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("EXT_2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("EXT_2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("EXT_2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("EXT_2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("EXT_3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("EXT_3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("EXT_3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("EXT_3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("EXT_3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("EXT_3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("EXT_3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("EXT_3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("EXT_3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("EXT_3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("EXT_3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("EXT_3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("EXT_3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt4IsNull() {
            addCriterion("EXT_4 is null");
            return (Criteria) this;
        }

        public Criteria andExt4IsNotNull() {
            addCriterion("EXT_4 is not null");
            return (Criteria) this;
        }

        public Criteria andExt4EqualTo(String value) {
            addCriterion("EXT_4 =", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotEqualTo(String value) {
            addCriterion("EXT_4 <>", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThan(String value) {
            addCriterion("EXT_4 >", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_4 >=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThan(String value) {
            addCriterion("EXT_4 <", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThanOrEqualTo(String value) {
            addCriterion("EXT_4 <=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Like(String value) {
            addCriterion("EXT_4 like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotLike(String value) {
            addCriterion("EXT_4 not like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4In(List<String> values) {
            addCriterion("EXT_4 in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotIn(List<String> values) {
            addCriterion("EXT_4 not in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Between(String value1, String value2) {
            addCriterion("EXT_4 between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotBetween(String value1, String value2) {
            addCriterion("EXT_4 not between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt5IsNull() {
            addCriterion("EXT_5 is null");
            return (Criteria) this;
        }

        public Criteria andExt5IsNotNull() {
            addCriterion("EXT_5 is not null");
            return (Criteria) this;
        }

        public Criteria andExt5EqualTo(String value) {
            addCriterion("EXT_5 =", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotEqualTo(String value) {
            addCriterion("EXT_5 <>", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThan(String value) {
            addCriterion("EXT_5 >", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_5 >=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThan(String value) {
            addCriterion("EXT_5 <", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThanOrEqualTo(String value) {
            addCriterion("EXT_5 <=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Like(String value) {
            addCriterion("EXT_5 like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotLike(String value) {
            addCriterion("EXT_5 not like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5In(List<String> values) {
            addCriterion("EXT_5 in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotIn(List<String> values) {
            addCriterion("EXT_5 not in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Between(String value1, String value2) {
            addCriterion("EXT_5 between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotBetween(String value1, String value2) {
            addCriterion("EXT_5 not between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt6IsNull() {
            addCriterion("EXT_6 is null");
            return (Criteria) this;
        }

        public Criteria andExt6IsNotNull() {
            addCriterion("EXT_6 is not null");
            return (Criteria) this;
        }

        public Criteria andExt6EqualTo(String value) {
            addCriterion("EXT_6 =", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotEqualTo(String value) {
            addCriterion("EXT_6 <>", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6GreaterThan(String value) {
            addCriterion("EXT_6 >", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_6 >=", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6LessThan(String value) {
            addCriterion("EXT_6 <", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6LessThanOrEqualTo(String value) {
            addCriterion("EXT_6 <=", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6Like(String value) {
            addCriterion("EXT_6 like", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotLike(String value) {
            addCriterion("EXT_6 not like", value, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6In(List<String> values) {
            addCriterion("EXT_6 in", values, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotIn(List<String> values) {
            addCriterion("EXT_6 not in", values, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6Between(String value1, String value2) {
            addCriterion("EXT_6 between", value1, value2, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt6NotBetween(String value1, String value2) {
            addCriterion("EXT_6 not between", value1, value2, "ext6");
            return (Criteria) this;
        }

        public Criteria andExt7IsNull() {
            addCriterion("EXT_7 is null");
            return (Criteria) this;
        }

        public Criteria andExt7IsNotNull() {
            addCriterion("EXT_7 is not null");
            return (Criteria) this;
        }

        public Criteria andExt7EqualTo(String value) {
            addCriterion("EXT_7 =", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotEqualTo(String value) {
            addCriterion("EXT_7 <>", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7GreaterThan(String value) {
            addCriterion("EXT_7 >", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_7 >=", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7LessThan(String value) {
            addCriterion("EXT_7 <", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7LessThanOrEqualTo(String value) {
            addCriterion("EXT_7 <=", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7Like(String value) {
            addCriterion("EXT_7 like", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotLike(String value) {
            addCriterion("EXT_7 not like", value, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7In(List<String> values) {
            addCriterion("EXT_7 in", values, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotIn(List<String> values) {
            addCriterion("EXT_7 not in", values, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7Between(String value1, String value2) {
            addCriterion("EXT_7 between", value1, value2, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt7NotBetween(String value1, String value2) {
            addCriterion("EXT_7 not between", value1, value2, "ext7");
            return (Criteria) this;
        }

        public Criteria andExt8IsNull() {
            addCriterion("EXT_8 is null");
            return (Criteria) this;
        }

        public Criteria andExt8IsNotNull() {
            addCriterion("EXT_8 is not null");
            return (Criteria) this;
        }

        public Criteria andExt8EqualTo(String value) {
            addCriterion("EXT_8 =", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotEqualTo(String value) {
            addCriterion("EXT_8 <>", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8GreaterThan(String value) {
            addCriterion("EXT_8 >", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_8 >=", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8LessThan(String value) {
            addCriterion("EXT_8 <", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8LessThanOrEqualTo(String value) {
            addCriterion("EXT_8 <=", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8Like(String value) {
            addCriterion("EXT_8 like", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotLike(String value) {
            addCriterion("EXT_8 not like", value, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8In(List<String> values) {
            addCriterion("EXT_8 in", values, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotIn(List<String> values) {
            addCriterion("EXT_8 not in", values, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8Between(String value1, String value2) {
            addCriterion("EXT_8 between", value1, value2, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt8NotBetween(String value1, String value2) {
            addCriterion("EXT_8 not between", value1, value2, "ext8");
            return (Criteria) this;
        }

        public Criteria andExt9IsNull() {
            addCriterion("EXT_9 is null");
            return (Criteria) this;
        }

        public Criteria andExt9IsNotNull() {
            addCriterion("EXT_9 is not null");
            return (Criteria) this;
        }

        public Criteria andExt9EqualTo(String value) {
            addCriterion("EXT_9 =", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotEqualTo(String value) {
            addCriterion("EXT_9 <>", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9GreaterThan(String value) {
            addCriterion("EXT_9 >", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9GreaterThanOrEqualTo(String value) {
            addCriterion("EXT_9 >=", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9LessThan(String value) {
            addCriterion("EXT_9 <", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9LessThanOrEqualTo(String value) {
            addCriterion("EXT_9 <=", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9Like(String value) {
            addCriterion("EXT_9 like", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotLike(String value) {
            addCriterion("EXT_9 not like", value, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9In(List<String> values) {
            addCriterion("EXT_9 in", values, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotIn(List<String> values) {
            addCriterion("EXT_9 not in", values, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9Between(String value1, String value2) {
            addCriterion("EXT_9 between", value1, value2, "ext9");
            return (Criteria) this;
        }

        public Criteria andExt9NotBetween(String value1, String value2) {
            addCriterion("EXT_9 not between", value1, value2, "ext9");
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