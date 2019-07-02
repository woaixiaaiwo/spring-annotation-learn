package com.boge.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 获取被注解的类的其他注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.boge.bean.Blue","com.boge.bean.Yello"};
    }
}
