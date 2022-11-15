package org.harmony.endofline.model;

import javax.validation.Validator;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


class ValidatorTest {
    private Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }
}
