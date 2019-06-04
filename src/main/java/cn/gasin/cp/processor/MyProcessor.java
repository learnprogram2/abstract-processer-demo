package cn.gasin.cp.processor;

import cn.gasin.cp.anno.MyAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author wongyiming
 * @date 2019/6/4 16:21
 */
@SupportedAnnotationTypes("cn.gasin.cp.anno.MyAnnotation")
public class MyProcessor extends AbstractProcessor {
	/**
	 * {@inheritDoc}
	 *
	 * @param annotations 请求处理的注释类型
	 * @param roundEnv    有关当前和上一轮信息的环境
	 * @return 此处理器是否声明了注释类型集
	 */
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("11111111111111111111111111111111111111");
		Messager messager = processingEnv.getMessager();
		for (TypeElement te : annotations) {
			for (Element e : roundEnv.getElementsAnnotatedWith(te)) {
				messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " + e.toString());
			}
		}
		return true;
	}


	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}


	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> annotations = new LinkedHashSet<>();
		//把我们自己定义的注解添加进去
		annotations.add(MyAnnotation.class.getCanonicalName());
		return annotations;
	}


}
