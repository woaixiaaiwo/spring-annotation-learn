package com.boge.custom;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义扫描规则，会扫描包下的每一个类，不管该类是否使用了Spring的组件注解
 */
public class CustomTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader 当前正在读取的类的信息
     * @param metadataReaderFactory 可以获取到其他类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        
        ///获取当前正在扫描的类的类信息
        final ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //获取当前正在扫描类的资源信息
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();

        System.out.println("扫描了--->"+className);

        if(className.contains("er")){
            return  true;
        }

        return false;
    }
}
