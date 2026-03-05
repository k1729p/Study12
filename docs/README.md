<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8"><body>
<a href="https://github.com/k1729p/Study12/tree/main/docs"><img alt="" src="images/ColorScheme.png" height="25" width="800"/></a>
<h2 id="contents">Study12 README Contents</h2>
<h3 id="top">Research Swing, Bean Validation, CDI, and RESTful Web Services</h3>
<p>
The sections of this project:
</p>
<ol>
	<li><a href="#swing">Swing Application Start</a></li>
	<li><a href="#valid">Bean Validation using Jakarta Bean Validation</a>
		<ul>
			<li><a href="#valid_item">Validation Example "Validate Item"</a></li>
			<li><a href="#valid_box">Validation Example "Validate Box Of Items"</a></li>
			<li><a href="#valid_method">Validation Example "Validate Method"</a></li>
		</ul>
	</li>
	<li><a href="#c_d_i">CDI using JBoss Weld SE Container</a>
		<ul>
			<li><a href="#c_d_i_alternative">CDI Example "Alternative &amp; Qualified Beans"</a></li>
			<li><a href="#c_d_i_decorated">CDI Example "Decorated Beans"</a></li>
			<li><a href="#c_d_i_intercepted">CDI Example "Intercepted Beans"</a></li>
			<li><a href="#c_d_i_events">CDI Example "Events"</a></li>
		</ul>
	</li>
	<li><a href="#restful">RESTful Web Services using HTTP Server</a>
		<ul>
			<li><a href="#restful_content">RESTful Example "Content GET"</a></li>
			<li><a href="#restful_boxes_internal">RESTful Example "Boxes CRUD (Internal Client)"</a></li>
			<li><a href="#restful_boxes_external">RESTful Example "Boxes CRUD (External Client)"</a></li>
		</ul>
	</li>
</ol>

<p>Java source code:<br>
<img alt="" src="images/aquaHR-500.png"><br>
<img alt="" src="images/aquaSquare.png"> package 
	<a href="https://github.com/k1729p/Study12/tree/master/src/main/java/kp">kp</a><br>
<img alt="" src="images/aquaHR-500.png">
</p>

<p>
<img alt="" src="images/yellowHR-500.png"><br>
<img alt="" src="images/yellowSquare.png">
    <a href="http://htmlpreview.github.io/?https://github.com/k1729p/Study12/blob/main/docs/apidocs/index.html">
	Java API Documentation</a><br>
<img alt="" src="images/yellowHR-500.png">
</p>

<hr>
<h2 id="swing">❶ Swing Application Start</h2>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. With batch file 
'<a href="https://github.com/k1729p/Study12/blob/main/0_batch/01%20MVN%20clean%20install%20exec.bat">01 MVN clean install exec.bat</a>'
build and start the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/Application.java">Application</a>'.<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p><img alt="" src="images/MainMenu.png" height="131" width="610"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from application main menu.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<h2 id="valid">❷ Bean Validation using <a href="https://beanvalidation.org/">Jakarta Bean Validation</a></h2>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validation".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p><img alt="" src="images/BeanValidation.png" height="132" width="585"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Bean Validation" submenu.</i>
</p>

<h3 id="valid_item"><img alt="" src="images/greenCircle.png"> 2.1. Validation Example "Validate Item"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validate Item".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>2.1.1. The interface '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/ItemCons.java">ItemCons</a>' 
has the property-level constraint with pattern '.*Ret'.<br>
The constraint is placed on the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/ItemCons.java#L24">ItemCons::getVal</a>' method.
</p>
<p>2.1.2. This interface has two implementations: 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' and 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>'.<br>
Both implementations inherit the constraint from the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/ItemCons.java">ItemCons</a>' interface.
</p>
<ul>
<li>The implementation 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' 
has no constraints in its body.<br>
The implemented method: '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java#L27">
ItemConsImplNoCons::getVal</a>'.
</li>
<li>The implementation 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' 
has a new additional constraint defined.<br>
This is the field-level constraint with the pattern 'Fld.*' placed on the 'val' field.<br>
The implemented method: '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java#L30">
ItemConsImplCons::getVal</a>'.
</li>
</ul>
<p>2.1.3. In the method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/ResearchValidation.java#L80">ResearchValidation::validateItem</a>'
four values were validated with 'jakarta.validation.Validator'.
These values are presented on the tab "Validated Values".<br>
Each value was set in a loop on new instances: 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' and 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>'.
</p>
<p>2.1.4. From the results, it is evident which constraints were active in the validation process.
</p>
<ul>
<li>Class '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' 
has only one active constraint:<br>
the inherited property-level constraint '.*Ret'.
</li>
<li>Class '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' 
has two active constraints:<br>
the inherited property-level constraint '.*Ret' and its field-level constraint 'Fld.*'.
</li>
</ul>

<p><img alt="" src="images/ValidateItem1.png" height="350" width="560"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Validate Item" action - tab "Validation Results".</i>
</p>

<p><img alt="" src="images/ValidateItem2.png" height="332" width="561"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Validate Item" action - tab "Validated Values".</i>
</p>

<a href="#top">Back to the top of the page</a>
<h3 id="valid_box"><img alt="" src="images/greenCircle.png"> 2.2. Validation Example "Validate Box Of Items"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validate Box Of Items".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>2.2.1. The class '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/BoxCons.java">BoxCons</a>' 
has these constraints:
</p>
<ul>
<li>a constraint on the field 'list': "Not Null"</li>
<li>a validation cascading on the field 'list':<br>
validates constraints on the list elements 
('<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' instances)
</li>
<li>a constraint on the field 'decimal': between minimal value 10 and maximal value 100</li>
</ul>
<p>2.2.2. In the method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/ResearchValidation.java#L129">ResearchValidation::validateBoxOfItems</a>'
two validations were executed.
</p>
<p>2.2.3. In the first validation, there were 2 constraint violations:<br>
	"not null" for 'list' equals null and "min value 10" for 'decimal' equal 1.
</p>
<p>2.2.4. In the second validation, there were 4 constraint violations for 'list'.<br>
That list contains 4 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' 
objects with values presented on the tab "Validated Values".<br>
The results of that list validation are similar to the results presented in the example "Validate Item" above.
</p>

<p><img alt="" src="images/ValidateBoxOfItems1.png" height="265" width="680"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Validate Box Of Items" action - tab "Validation Results".</i>
</p>

<p><img alt="" src="images/ValidateBoxOfItems2.png" height="267" width="681"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Validate Box Of Items" action - tab "Validated Values".</i>
</p>

<a href="#top">Back to the top of the page</a>
<h3 id="valid_method"><img alt="" src="images/greenCircle.png"> 2.3. Validation Example "Validate Method"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validate Method".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>2.3.1. The interface 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/OperatorCons.java">OperatorCons</a>' 
has two constraints on method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/OperatorCons.java#L21">OperatorCons::process</a>':
</p>
<ul>
<li>a constraint on the method parameter: minimal value 2</li>
<li>a constraint on the method return value: maximal value 1</li>
</ul>
<p>2.3.2. In the method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/ResearchValidation.java#L196">ResearchValidation::validateOperatorMethod</a>'
four validations were executed:
</p>
<ul>
<li>the two validations on the method parameter: the first with value 1 and the second with value 2</li>
<li>the two validations on the method return value: the first with value 2 and the second with value 1</li>
</ul>
<p>2.3.3. In the '<i>method parameters</i>' validation there was a '<i>parameter constraint</i>' violation:<br>
"min value 2" for parameter equal 1.
</p>
<p>2.3.4. In the '<i>method return value</i>' validation there was a '<i>return value constraint</i>' violation:<br>
"max value 1" for return value equals 2.
</p>

<p><img alt="" src="images/ValidateMethod.png" height="209" width="661"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Validate Method" action.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<h2 id="c_d_i">❸ CDI using JBoss Weld SE Container</h2>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "CDI".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java">ResearchCDIBean</a>' 
runs in a Weld SE container. The <a href="http://weld.cdi-spec.org/">Weld</a> is the reference implementation of CDI.<br>

<p><img alt="" src="images/CDI.png" height="132" width="950"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "CDI using Weld SE Container" submenu.</i>
</p>

<h3 id="c_d_i_alternative"><img alt="" src="images/greenCircle.png"> 3.1. CDI Example "Alternative &amp; Qualified Beans"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Alternative &amp; Qualified Beans".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>3.1.1. The interface '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBean.java">BasicBean</a>' 
has three implementations:
</p>
<ul>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImpl.java">BasicBeanImpl</a>'</li>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplAlt.java">BasicBeanImplAlt</a>' - 
this is the alternative bean
</li>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplScript.java">BasicBeanImplScript</a>' - 
it uses the qualifier '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/Script.java">@Script</a>'
</li>
</ul>
<p>3.1.2. The alternative bean
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplAlt.java">BasicBeanImplAlt</a>' 
is enabled in the bean archive descriptor 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The alternative bean is tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L120">
ResearchCDIBean::alternativeAndQualifiedBeans</a>'.
</p>
<p>3.1.3. The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplScript.java#L36">BasicBeanImplScript::show</a>'
replaces the alphabetic characters with the Unicode script characters.
</p>
<p>3.1.4. Here are used the two instances of the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplScript.java">BasicBeanImplScript</a>'  bean:
</p>
<ul>
<li>The 1st is injected with the qualifier '@Script'</li>
<li>The 2nd is selected with the qualifier '@Script' from injected <b>Instance</b> object</li>
</ul>
<p>3.1.5. In the '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java">ResearchCDIBean</a>'
three 'foreseeable' strings were injected with the
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/producers/Foreseeable.java">@Foreseeable</a>' qualifier:
</p>
<ul>
<li>'foreseeable' using default parameters in the qualifier</li>
<li>'foreseeable' with different 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/producers/ForeseeableDate.java">ForeseeableDate</a>' 
(the 'value' parameter was changed from default 'FAR' to 'NEAR')
</li>
<li>'foreseeable' with customized date format (the 'pattern' parameter replaced)</li>
</ul>
<p>3.1.6. The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L148">ResearchCDIBean::note</a>'
presents those three 'foreseeable' objects.
</p>

<p><img alt="" src="images/AlternativeAndQualifiedBeans1.png" height="243" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Alternative &amp; Qualified Beans" action.</i>
</p>

<p>3.1.7. The same push button action was repeated with the alternative bean switched off in the file 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The result is the replacement of the bean 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplAlt.java">BasicBeanImplAlt</a>' 
with the bean 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImpl.java">BasicBeanImpl</a>'.
</p>

<p><img alt="" src="images/AlternativeAndQualifiedBeans2.png" height="243" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Alternative &amp; Qualified Beans" action with switched-off alternatives.</i>
</p>

<a href="#top">Back to the top of the page</a>
<h3 id="c_d_i_decorated"><img alt="" src="images/greenCircle.png"> 3.2. CDI Example "Decorated Beans"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Decorated Beans".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>3.2.1. The interface 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBean.java">PlainBean</a>' has two implementations:
</p>
<ul>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBeanImpl.java">PlainBeanImpl</a>'</li>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/DecoratedBeanImpl.java">DecoratedBeanImpl</a>' - 
this is the decorated bean
</li>
</ul>
<p>3.2.2. The decorated bean
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/DecoratedBeanImpl.java">DecoratedBeanImpl</a>' 
is enabled in the bean archive descriptor 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The decorated bean is tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L158">ResearchCDIBean::decoratedBeans</a>'.
</p>
<p>3.2.3. The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/DecoratedBeanImpl.java#L45">DecoratedBeanImpl::show</a>'
calls the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBeanImpl.java#L34">PlainBeanImpl::show</a>' two times:
</p>
<ul>
<li>The 1st time with unchanged content</li>
<li>The 2nd time with reversed content</li>
</ul>

<p><img alt="" src="images/DecoratedBeans1.png" height="242" width="874"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Decorated Beans" action.</i>
</p>

<p>3.2.4. The same button action was repeated with the decorated bean switched off in the file 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
In the results, there is only one single call to the
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBeanImpl.java#L34">PlainBeanImpl::show</a>' method.
</p>

<p><img alt="" src="images/DecoratedBeans2.png" height="244" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Decorated Beans" action with switched-off decorators.</i>
</p>

<a href="#top">Back to the top of the page</a>
<h3 id="c_d_i_intercepted"><img alt="" src="images/greenCircle.png"> 3.3. CDI Example "Intercepted Beans"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Intercepted Beans".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>3.3.1. The interceptor class 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedInterceptor.java">ElapsedInterceptor</a>' 
is enabled in the bean archive descriptor 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The intercepted bean is tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L172">ResearchCDIBean::interceptedBeans</a>'.
</p>
<p>3.3.2. The interceptor computes in the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedInterceptor.java#L48">
ElapsedInterceptor::measure</a>' the method's execution.<br>
The measured bean '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java">ElapsedBean</a>' 
has four methods:
</p>
<ul>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L15">ElapsedBean::notPaused</a>' -
runs without any pause (empty method with empty body)
</li>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L24">ElapsedBean::pausedNano</a>' -
pauses one nanosecond
</li>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L36">ElapsedBean::pausedMicro</a>' -
pauses one microsecond
</li>
<li>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L48">ElapsedBean::pausedMilli</a>' -
pauses one millisecond
</li>
</ul>
<p>3.3.3. Those four methods were executed in a sequence ten times.
The results show that measuring elapsed time with an interceptor was correct only for the 'pausedMilli' method.
</p>

<p><img alt="" src="images/InterceptedBeans.png" height="244" width="892"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Intercepted Beans" action.</i>
</p>

<a href="#top">Back to the top of the page</a>
<h3 id="c_d_i_events"><img alt="" src="images/greenCircle.png"> 3.4. CDI Example "Events"</h3>

<p>The CDI advantage: no type erasure for the event type.
</p>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Events".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>3.4.1. The events were tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L191">ResearchCDIBean::fireEvents</a>'.<br>
Three types of events were fired:
</p>
<ul>
<li>The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>' event</li>
<li>The 'List&lt;<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>&gt;' event</li>
<li>The 'List&lt;String&gt;' event</li>
</ul>
<p>3.4.2. The abstract class
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java">BasicObserver</a>'
has the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java#L39">BasicObserver::showPayload</a>'.<br>
There are two implementations of the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java">BasicObserver</a>' class: 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/SmallObserver.java">SmallObserver</a>' and 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java">BigObserver</a>'.
</p>
<p>3.4.3. The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/SmallObserver.java">SmallObserver</a>' 
class observes only the '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>' 
event in the parent class method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java#L39">BasicObserver::showPayload</a>'.
</p>
<p>3.4.4. The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java">BigObserver</a>' 
class observes all three events:
</p>
<ul>
<li>The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>'
event in the parent class method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java#L39">
BasicObserver::showPayload</a>'
</li>
<li>The 'List&lt;<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>&gt;'
event in the method '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java#L33">
BigObserver::showPayloadList</a>'
</li>
<li>The 'List&lt;String&gt;' event in the method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java#L47">
BigObserver::showTextList</a>'
</li>
</ul>

<p><img alt="" src="images/Events.png" height="243" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Events" action.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<h2 id="restful">❹ RESTful Web Services using HTTP Server</h2>

Examples based on <a href ="https://jersey.github.io/documentation/latest/user-guide.html">Jersey User Guide</a>.<br>

<p><img alt="" src="images/RESTful.png" height="131" width="761"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "RESTful Web Services using HTTP Server" submenu.</i>
</p>

<h3 id="restful_content"><img alt="" src="images/greenCircle.png"> 4.1. RESTful Example "Content GET"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Content GET".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>4.1.1 The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/ResearchRestful.java#L42">ResearchRestful::process</a>'
</p>
<ul>
<li>Creates a new Grizzly HTTP Server instance, which scans for components in
<a href="https://github.com/k1729p/Study12/tree/master/src/main/java/kp/restful/data">kp.restful.data</a>
</li>
<li>Starts the JAX-RS client wrapper
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/ContentClient.java">ContentClient</a>'
</li>
</ul>
<p>4.1.2 The 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/ContentClient.java">ContentClient</a>' 
gets the content from the root resource 
<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java">Content</a>' using path and query parameters.<br>
The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/ContentClient.java#L37">ContentClient::process</a>'
sends two HTTP requests:
</p>
<ol>
<li>Request with URI '<a href="http://localhost:8080/content/pq/P-a-t-P-a-r?que_par=Q-u-e-P-a-r">
http://localhost:8080/content/pq/P-a-t-P-a-r?que_par=Q-u-e-P-a-r</a>'
</li>
<li>Request with URI '<a href="http://localhost:8080/content/c/P-a-t-P-a-r?que_par=Q-u-e-P-a-r">
http://localhost:8080/content/c/P-a-t-P-a-r?que_par=Q-u-e-P-a-r</a>
</li>
</ol>
<p>4.1.3. The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java">Content</a>'
has two methods with the <i>resource method designator</i> annotation '@GET':
</p>
<ul>
<li>The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java#L39">Content::getUsingPathAndQuery</a>':<br>
annotations '@PathParam' and '@QueryParam', parameter type 'String'
</li>
<li>The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java#L62">Content::getUsingContext</a>':<br>
annotation '@Context', parameter type 'UriInfo'
</li>
</ul>

<p><img alt="" src="images/ContentGET.png" height="236" width="1005"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Content GET" action.</i>
</p>

<a href="#top">Back to the top of the page</a>
<h3 id="restful_boxes_internal"><img alt="" src="images/greenCircle.png"> 4.2. RESTful Example "Boxes CRUD (Internal Client)"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Boxes CRUD (Internal Client)".<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p>4.2.1 The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/ResearchRestful.java#L42">ResearchRestful::process</a>'
</p>
<ul>
<li>Creates a new Grizzly HTTP Server instance, which scans for components in
<a href="https://github.com/k1729p/Study12/tree/master/src/main/java/kp/restful/data">kp.restful.data</a>
</li>
<li>Starts the JAX-RS client wrapper
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/BoxesClient.java">BoxesClient</a>'
</li>
</ul>

<p>4.2.2 The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/BoxesClient.java#L33">BoxesClient::process</a>'
sends CREATE, READ, UPDATE, and DELETE requests to the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java">SetOfBoxes</a>'.
</p>
<p>4.2.3 Requests No. 1, No. 2, and No. 3 create three new 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' objects.<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L53">SetOfBoxes::createBox</a>'
validates 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' and puts the created 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' in a Map.<br>
It is not idempotent because it uses HTTP POST.
</p>
<p>4.2.4 Request No. 4 finds a 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
object with id 1.<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L81">SetOfBoxes::readBox</a>'
uses HTTP GET.
</p>
<p>4.2.5 Request No. 5 finds all 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
objects and returns the list.
<br>The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L102">SetOfBoxes::readBoxes</a>'
uses HTTP GET.
</p>
<p>4.2.6 The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
object is updated two times in a row (requests No. 6 and No. 7) with the same data:<br>
id 1 and text "X".<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L126">SetOfBoxes::updateBox</a>' validates
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' and puts the updated 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' in a Map.<br>
It is idempotent because it uses HTTP PUT.
</p>
<p>4.2.7 Request No. 8 deletes the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
object with id 2.<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L158">SetOfBoxes::deleteBox</a>'
uses HTTP DELETE.
</p>
<p>4.2.8 Request No. 9 reads all 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' objects.<br>
Here it is confirmed that the '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
object with id 1 was updated and the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' object with id 2 was deleted.
</p>
<p>4.2.9 Requests No. 10 and No. 11 fail after a validation constraint violation.<br>
The validation constraint violation exception returns a response with status code 400 'Bad Request'.<br>
Valid are only texts with the upper case characters (annotation @Pattern in the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' class).
</p>
<p>4.2.10 Requests No. 12 and No. 13 fail because 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' objects with that id do not exist.
</p>

<p><img alt="" src="images/BoxesCRUDInternal.png" height="718" width="1120"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Boxes CRUD (Internal Client)" action.</i>
</p>

<a href="#top">Back to the top of the page</a>
<h3 id="restful_boxes_external"><img alt="" src="images/greenCircle.png"> 4.3. RESTful Example "Boxes CRUD (External Client)"</h3>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Boxes CRUD (External Client)".<br>
<img alt="" src="images/orangeSquare.png"><img alt="" src="images/spacer-32.png">
The main application pauses and the HTTP server starts listening for HTTP requests.<br>
<img alt="" src="images/orangeSquare.png"> 2. Start batch file 
'<a href="https://github.com/k1729p/Study12/blob/main/0_batch/02%20CURL%20call%20server.bat">02 CURL call server.bat</a>'.<br>
<img alt="" src="images/orangeSquare.png"><img alt="" src="images/spacer-32.png">
This script uses 'curl' for sending HTTP requests: POST, GET, PUT, and DELETE.<br>
<img alt="" src="images/orangeSquare.png"> 3. After finishing the execution of the batch file press the 'Enter' button in the main window to shut down the server.<br>
<img alt="" src="images/orangeSquare.png"><img alt="" src="images/spacer-32.png">
The main application resumes running and shows the results in the "Boxes CRUD (External Client)" window.<br>
<img alt="" src="images/orangeHR-500.png">
</p>

<p><img alt="" src="images/BoxesCRUDExternal.png" height="209" width="666"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Screenshot from "Boxes CRUD (External Client)" action.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
</body>
</html>