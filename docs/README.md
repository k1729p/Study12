<!DOCTYPE html>
<HTML lang="en">
<META charset="UTF-8"><BODY>
<a href="https://github.com/k1729p/Study12/tree/main/docs"><img alt="" src="images/ColorScheme.png" height="25" width="800"/></a>
<H2 id="contents">Study12 README Contents</H2>
<H3 id="top">Research Swing, Bean Validation, CDI, and RESTful Web Services</H3>
<p>
The sections of this project:
</p>
<OL>
	<LI><A href="#swing">Swing Application Start</A>
	<LI><A href="#valid">Bean Validation</A>
		<UL>
			<LI><A href="#valid_item">Validation Example "Validate Item"</A></LI>
			<LI><A href="#valid_box">Validation Example "Validate Box Of Items"</A></LI>
			<LI><A href="#valid_method">Validation Example "Validate Method"</A></LI>
		</UL></LI>
	<LI><A href="#c_d_i">CDI using JBoss Weld SE Container</A>
		<UL>
			<LI><A href="#c_d_i_alternative">CDI Example "Alternative &amp; Qualified Beans"</A></LI>
			<LI><A href="#c_d_i_decorated">CDI Example "Decorated Beans"</A></LI>
			<LI><A href="#c_d_i_intercepted">CDI Example "Intercepted Beans"</A></LI>
			<LI><A href="#c_d_i_events">CDI Example "Events"</A></LI>
		</UL></LI>
	<LI><A href="#restful">RESTful Web Services using HTTP Server</A>
		<UL>
			<LI><A href="#restful_content">RESTful Example "Content GET"</A></LI>
			<LI><A href="#restful_boxes_internal">RESTful Example "Boxes CRUD (Internal Client)"</A></LI>
			<LI><A href="#restful_boxes_external">RESTful Example "Boxes CRUD (External Client)"</A></LI>
		</UL></LI>
</OL>

<P>Java source code:<br>
<img alt="" src="images/aquaHR-500.png"><br>
<img alt="" src="images/aquaSquare.png"> package 
	<a href="https://github.com/k1729p/Study12/tree/master/src/main/java/kp">kp</a><br>
<img alt="" src="images/aquaHR-500.png"></P>

<p>
<img alt="" src="images/yellowHR-500.png"><br>
<img alt="" src="images/yellowSquare.png">
    <a href="http://htmlpreview.github.io/?https://github.com/k1729p/Study12/blob/main/docs/apidocs/index.html">
	Java API Documentation</a><br>
<img alt="" src="images/yellowHR-500.png">
</p>

<hr>
<H2 id="swing">❶ Swing Application Start</H2>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. With batch file 
'<a href="https://github.com/k1729p/Study12/blob/main/0_batch/01%20MVN%20clean%20install%20exec.bat">01 MVN clean install exec.bat</a>'
build and start the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/Application.java">Application</a>'.<br>
<img alt="" src="images/orangeHR-500.png"></P>

<P><img alt="" src="images/MainMenu.png" height="131" width="610"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from application main menu.</I></P>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="valid">❷ Bean Validation</H2>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validation".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<P><img alt="" src="images/BeanValidation.png" height="132" width="585"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Bean Validation" submenu.</I></P>

<H3 id="valid_item"><img alt="" src="images/greenCircle.png"> 2.1. Validation Example "Validate Item"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validate Item".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>2.1.1. The interface '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/ItemCons.java">ItemCons</a>' 
has the property-level constraint with pattern '.*Ret'.<br>
The constraint is placed on the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/ItemCons.java#L25">ItemCons::getVal</a>' method.
</p>
<p>2.1.2. This interface has two implementations: 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' and 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>'.<br>
Both implementations inherit the constraint from the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/ItemCons.java">ItemCons</a>' interface.
</p>
<UL>
<LI>The implementation 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' 
has no constraints in its body.<br>
The implemented method: '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java#L34">
ItemConsImplNoCons::getVal</a>'.
</LI>
<LI>The implementation 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' 
has a new additional constraint defined.<br>
This is the field-level constraint with the pattern 'Fld.*' placed on the 'val' field.<br>
The implemented method: '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java#L39">
ItemConsImplCons::getVal</a>'.
</LI>
</UL>
<p>2.1.3. In the method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/ResearchValidation.java#L97">ResearchValidation::validateItem</a>'
there were validated 4 values with 'jakarta.validation.Validator'. 
These values are presented on the tab "Validated Values".<br>
Each value was set in a loop on new instances: 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' and 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>'.
</p>
<p>2.1.4. From the results it is evident what constraints were active in the validation process.
</p>
<UL>
<LI>Class '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplNoCons.java">ItemConsImplNoCons</a>' 
has only one active constraint:<br>
the inherited property-level constraint '.*Ret'.</LI>
<LI>Class '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' 
has two active constraints:<br>
the inherited property-level constraint '.*Ret' and its field-level constraint 'Fld.*'.</LI>
</UL>

<P><img alt="" src="images/ValidateItem1.png" height="331" width="561"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Validate Item" action - tab "Validation Results".</I></P>

<P><img alt="" src="images/ValidateItem2.png" height="332" width="561"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Validate Item" action - tab "Validated Values".</I></P>

<a href="#top">Back to the top of the page</a>
<H3 id="valid_box"><img alt="" src="images/greenCircle.png"> 2.2. Validation Example "Validate Box Of Items"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validate Box Of Items".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>2.2.1. The class '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/BoxCons.java">BoxCons</a>' 
has these constraints:
</p>
<UL>
<LI>a constraint on the field 'list': "Not Null"</LI>
<LI>a validation cascading on the field 'list':<br>
validates constraints on the list elements 
('<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' instances)</LI>
<LI>a constraint on the field 'decimal': between minimal value 10 and maximal value 100</LI>
</UL>
<p>2.2.2. In the method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/ResearchValidation.java#L147">ResearchValidation::validateBoxOfItems</a>'
there were executed two validations.
</p>
<p>2.2.3. In the first validation there were 2 constraint violations:<br>
	"not null" for 'list' equals null and "min value 10" for 'decimal' equal 1.
</p>
<p>2.2.4. In the second validation there were 4 constraint violations for 'list'.<br>
That list contains 4 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/impl/ItemConsImplCons.java">ItemConsImplCons</a>' 
objects with values presented on the tab "Validated Values".<br>
The results of that list validation are similar to the results presented in the example "Validate Item" above.
</p>

<P><img alt="" src="images/ValidateBoxOfItems1.png" height="265" width="680"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Validate Box Of Items" action - tab "Validation Results".</I></P>

<P><img alt="" src="images/ValidateBoxOfItems2.png" height="267" width="681"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Validate Box Of Items" action - tab "Validated Values".</I></P>

<a href="#top">Back to the top of the page</a>
<H3 id="valid_method"><img alt="" src="images/greenCircle.png"> 2.3. Validation Example "Validate Method"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Validate Method".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>2.3.1. The interface 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/OperCons.java">OperCons</a>' 
has two constraints on method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/data/OperCons.java#L22">OperCons::process</a>':
</p>
<UL>
<LI>a constraint on the method parameter: minimal value 2</LI>
<LI>a constraint on the method return value: maximal value 1</LI>
</UL>
<p>2.3.2. In the method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/validation/ResearchValidation.java#L219">ResearchValidation::validateOperMethod</a>'
there were executed four validations:
</p>
<UL>
<LI>the two validations on the method parameter: the first with value 1 and the second with value 2</LI>
<LI>the two validations on the method return value: the first with value 2 and the second with value 1</LI>
</UL>
<p>2.3.3. In the '<i>method parameters</i>' validation there was a '<i>parameter constraint</i>' violation:<br>
"min value 2" for parameter equal 1.
</p>
<p>2.3.4. In the '<i>method return value</i>' validation there was a '<i>return value constraint</i>' violation:<br>
"max value 1" for return value equals 2.
</p>

<P><img alt="" src="images/ValidateMethod.png" height="209" width="661"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Validate Method" action.</I></P>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="c_d_i">❸ CDI using JBoss Weld SE Container</H2>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "CDI".<br>
<img alt="" src="images/orangeHR-500.png"></P>

The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java">ResearchCDIBean</a>' 
runs in a Weld SE container. The <A href="http://weld.cdi-spec.org/">Weld</A> is the reference implementation of CDI.<br>

<P><img alt="" src="images/CDI.png" height="132" width="950"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "CDI using Weld SE Container" submenu.</I></P>

<H3 id="c_d_i_alternative"><img alt="" src="images/greenCircle.png"> 3.1. CDI Example "Alternative &amp; Qualified Beans"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Alternative &amp; Qualified Beans".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>3.1.1. The interface '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBean.java">BasicBean</a>' 
has three implementations:
</p>
<UL>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImpl.java">BasicBeanImpl</a>'</LI>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplAlt.java">BasicBeanImplAlt</a>' - 
this is the alternative bean</LI>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplScript.java">BasicBeanImplScript</a>' - 
it uses the qualifier '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/Script.java">@Script</a>'</LI>
</UL>
<p>3.1.2. The alternative bean
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplAlt.java">BasicBeanImplAlt</a>' 
is enabled in the bean archive descriptor 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The alternative bean is tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L138">
ResearchCDIBean::alternativeAndQualifiedBeans</a>'.
</p>
<p>3.1.3. The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplScript.java#L38">BasicBeanImplScript::show</a>'
replaces the alphabetic characters with the Unicode script characters.
</p>
<p>3.1.4. Here are used the two instances of the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplScript.java">BasicBeanImplScript</a>'  bean:
</p>
<UL>
<LI>the 1st is injected with the qualifier '@Script'</LI>
<LI>the 2nd is selected with the qualifier '@Script' from injected <B>Instance</B> object</LI>
</UL>
<p>3.1.5. Into the '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java">ResearchCDIBean</a>'
there were injected three 'foreseeable' strings with the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/producers/Foreseeable.java">@Foreseeable</a>' qualifier:
</p>
<UL>
<LI>'foreseeable' using default parameters in the qualifier</LI>
<LI>'foreseeable' with different 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/producers/ForeseeableDate.java">ForeseeableDate</a>' 
(the 'value' parameter was changed from default 'FAR' to 'NEAR')</LI>
<LI>'foreseeable' with customized date format (the 'pattern' parameter replaced)</LI>
</UL>
<p>3.1.6. The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L162">ResearchCDIBean::note</a>'
presents those three 'foreseeable' objects.
</p>

<P><img alt="" src="images/AlternativeAndQualifiedBeans1.png" height="243" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Alternative &amp; Qualified Beans" action.</I></P>

<p>3.1.7. The same push button action was repeated with the alternative bean switched off in the file 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The result is the replacement of the bean 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImplAlt.java">BasicBeanImplAlt</a>' 
with the bean 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/alternatives/BasicBeanImpl.java">BasicBeanImpl</a>'.
</p>

<P><img alt="" src="images/AlternativeAndQualifiedBeans2.png" height="243" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Alternative &amp; Qualified Beans" action with switched-off alternatives.</I></P>

<a href="#top">Back to the top of the page</a>
<H3 id="c_d_i_decorated"><img alt="" src="images/greenCircle.png"> 3.2. CDI Example "Decorated Beans"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Decorated Beans".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>3.2.1. The interface 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBean.java">PlainBean</a>' has two implementations:
</p>
<UL>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBeanImpl.java">PlainBeanImpl</a>'</LI>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/DecoratedBeanImpl.java">DecoratedBeanImpl</a>' - 
this is the decorated bean</LI>
</UL>
<p>3.2.2. The decorated bean
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/DecoratedBeanImpl.java">DecoratedBeanImpl</a>' 
is enabled in the bean archive descriptor 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The decorated bean is tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L174">ResearchCDIBean::decoratedBeans</a>'.
</p>
<p>3.2.3. The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/DecoratedBeanImpl.java#L47">DecoratedBeanImpl::show</a>'
calls the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBeanImpl.java#L36">PlainBeanImpl::show</a>' two times:
</p>
<UL>
<LI>the 1st time with unchanged content</LI>
<LI>the 2nd time with reversed content</LI>
</UL>

<P><img alt="" src="images/DecoratedBeans1.png" height="242" width="874"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Decorated Beans" action.</I></P>

<P>3.2.4. The same button action was repeated with the decorated bean switched off in the file 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
In the results there is only one single call to the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/decorators/PlainBeanImpl.java#L36">PlainBeanImpl::show</a>' method.
</P>

<P><img alt="" src="images/DecoratedBeans2.png" height="244" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Decorated Beans" action with switched-off decorators.</I></P>

<a href="#top">Back to the top of the page</a>
<H3 id="c_d_i_intercepted"><img alt="" src="images/greenCircle.png"> 3.3. CDI Example "Intercepted Beans"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Intercepted Beans".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>3.3.1. The interceptor class 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedInterceptor.java">ElapsedInterceptor</a>' 
is enabled in the bean archive descriptor 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/resources/META-INF/beans.xml">beans.xml</a>'.<br>
The intercepted bean is tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L189">ResearchCDIBean::interceptedBeans</a>'.
</p>
<p>3.3.2. The interceptor computes in the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedInterceptor.java#L45">
ElapsedInterceptor::measure</a>' the method's execution.<br>
The measured bean '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java">ElapsedBean</a>' 
has four methods:
</p>
<UL>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L25">ElapsedBean::notPaused</a>' -
runs without any pause (empty method with empty body)</LI>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L35">ElapsedBean::pausedNano</a>' -
pauses one nanosecond</LI>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L48">ElapsedBean::pausedMicro</a>' -
pauses one microsecond</LI>
<LI>'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/interceptors/ElapsedBean.java#L61">ElapsedBean::pausedMilli</a>' -
pauses one millisecond</LI>
</UL>
<p>3.3.3. Those four methods were executed in a sequence ten times.
The results show that measuring elapsed time with an interceptor was correct only for the 'pausedMilli' method.
</p>

<P><img alt="" src="images/InterceptedBeans.png" height="244" width="892"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Intercepted Beans" action.</I></P>

<a href="#top">Back to the top of the page</a>
<H3 id="c_d_i_events"><img alt="" src="images/greenCircle.png"> 3.4. CDI Example "Events"</H3>

<P>The CDI advantage: no type erasure for the event type.</P>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Events".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>3.4.1. The events were tested with the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/ResearchCDIBean.java#L209">ResearchCDIBean::fireEvents</a>'.<br>
There were fired three types of events:
</p>
<UL>
<LI>the '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>' event</LI>
<LI>the 'List&lt;<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>&gt;' event</LI>
<LI>the 'List&lt;String&gt;' event</LI>
</UL>
<p>3.4.2. The abstract class
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java">BasicObserver</a>'
has the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java#L36">BasicObserver::showPayload</a>'.<br>
There are two implementations of the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java">BasicObserver</a>' class: 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/SmallObserver.java">SmallObserver</a>' and 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java">BigObserver</a>'.
</p>
<p>3.4.3. The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/SmallObserver.java">SmallObserver</a>' 
class observes only the '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>' 
event in the parent class method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java#L36">BasicObserver::showPayload</a>'.
</p>
<p>3.4.4. The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java">BigObserver</a>' 
class observes all three events:
</p>
<UL>
<LI>the '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>' 
event in the parent class method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BasicObserver.java#L36">
BasicObserver::showPayload</a>'</LI>
<LI>the 'List&lt;<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/Payload.java">Payload</a>&gt;' 
event in the method '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java#L38">
BigObserver::showPayloadList</a>'</LI>
<LI>the 'List&lt;String&gt;' event in the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/cdi/events/observers/BigObserver.java#L52">
BigObserver::showTextList</a>'</LI>
</UL>

<P><img alt="" src="images/Events.png" height="243" width="876"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Events" action.</I></P>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="restful">❹ RESTful Web Services using HTTP Server</H2>

Examples based on <A href ="https://jersey.github.io/documentation/latest/user-guide.html">Jersey User Guide</A>.<br>

<P><img alt="" src="images/RESTful.png" height="131" width="761"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "RESTful Web Services using HTTP Server" submenu.</I></P>

<H3 id="restful_content"><img alt="" src="images/greenCircle.png"> 4.1. RESTful Example "Content GET"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Content GET".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>4.1.1 The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/ResearchRestful.java#L50">ResearchRestful::process</a>'
<UL>
<LI>creates a new Grizzly HTTP Server instance, which scans for components in 
<a href="https://github.com/k1729p/Study12/tree/master/src/main/java/kp/restful/data">kp.restful.data</a></LI>
<LI>starts the JAX-RS client wrapper 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/ContentClient.java">ContentClient</a>'</LI>
</UL>
<p>4.1.2 The 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/ContentClient.java">ContentClient</a>' 
gets the content from the root resource 
<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java">Content</a>' using path and query parameters.<br>
The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/ContentClient.java#L39">ContentClient::process</a>'
sends two HTTP requests:
</p>
<OL>
<LI>request with URI '<a href="http://localhost:8080/content/pq/P-a-t-P-a-r?que_par=Q-u-e-P-a-r">
http://localhost:8080/content/pq/P-a-t-P-a-r?que_par=Q-u-e-P-a-r</a>'</LI>
<LI>request with URI '<a href="http://localhost:8080/content/c/P-a-t-P-a-r?que_par=Q-u-e-P-a-r">
http://localhost:8080/content/c/P-a-t-P-a-r?que_par=Q-u-e-P-a-r</a></LI>
</OL>
<p>4.1.3. The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java">Content</a>'
has two methods with the <i>resource method designator</i> annotation '@GET':
</p>
<UL>
<LI>the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java#L41">Content::getUsingPathAndQuery</a>':<br>
annotations '@PathParam' and '@QueryParam', parameter type 'String'</LI>
<LI>the method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Content.java#L61">Content::getUsingContext</a>':<br>
annotation '@Context', parameter type 'UriInfo'</LI>
</UL>

<P><img alt="" src="images/ContentGET.png" height="236" width="1005"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Content GET" action.</I></P>

<a href="#top">Back to the top of the page</a>
<H3 id="restful_boxes_internal"><img alt="" src="images/greenCircle.png"> 4.2. RESTful Example "Boxes CRUD (Internal Client)"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Boxes CRUD (Internal Client)".<br>
<img alt="" src="images/orangeHR-500.png"></P>

<p>4.2.1 The method
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/ResearchRestful.java#L50">ResearchRestful::process</a>'
<UL>
<LI>creates a new Grizzly HTTP Server instance, which scans for components in 
<a href="https://github.com/k1729p/Study12/tree/master/src/main/java/kp/restful/data">kp.restful.data</a></LI>
<LI>starts the JAX-RS client wrapper 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/BoxesClient.java">BoxesClient</a>'</LI>
</UL>

<p>4.2.2 The method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/client/BoxesClient.java#L39">BoxesClient::process</a>'
sends CREATE, READ, UPDATE, and DELETE requests to the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java">SetOfBoxes</a>'.
</p>
<p>4.2.3 Requests No. 1, No. 2, and No. 3 create three new 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' objects.<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L63">SetOfBoxes::createBox</a>'
validates 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' and puts the created 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' in a Map.<br>
It is not idempotent because it uses HTTP POST.
</p>
<p>4.2.4 Request No. 4 finds a 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
object with id 1.<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L88">SetOfBoxes::readBox</a>'
uses HTTP GET.
</p>
<p>4.2.5 Request No. 5 finds all 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
objects and returns the list.
<br>The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L107">SetOfBoxes::readBoxes</a>'
uses HTTP GET.
</p>
<p>4.2.6 The '<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
object is updated two times in a row (requests No. 6 and No. 7) with the same data:<br>
id 1 and text "X".<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L128">SetOfBoxes::updateBox</a>' validates
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' and puts the updated 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' in a Map.<br>
It is idempotent because it uses HTTP PUT.
</p>
<p>4.2.7 Request No. 8 deletes the 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/Box.java">Box</a>' 
object with id 2.<br>
The resource method 
'<a href="https://github.com/k1729p/Study12/blob/main/src/main/java/kp/restful/data/SetOfBoxes.java#L157">SetOfBoxes::deleteBox</a>'
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

<P><img alt="" src="images/BoxesCRUDInternal.png" height="718" width="1120"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Boxes CRUD (Internal Client)" action.</I></P>

<a href="#top">Back to the top of the page</a>
<H3 id="restful_boxes_external"><img alt="" src="images/greenCircle.png"> 4.3. RESTful Example "Boxes CRUD (External Client)"</H3>

<P>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. Push the button "Boxes CRUD (External Client)".<br>
<img alt="" src="images/orangeSquare.png"><img alt="" src="images/spacer-32.png">
The main application pauses and the HTTP server starts listening for HTTP requests.<br>
<img alt="" src="images/orangeSquare.png"> 2. Start batch file 
'<a href="https://github.com/k1729p/Study12/blob/main/0_batch/02%20CURL%20call%20server.bat">02 CURL call server.bat</a>'.<br>
<img alt="" src="images/orangeSquare.png"><img alt="" src="images/spacer-32.png">
This script uses 'curl' for sending HTTP requests: POST, GET, PUT, and DELETE.<br>
<img alt="" src="images/orangeSquare.png"> 3. After finishing the execution of the batch file press button 'Enter' in the main window to shut down the server.<br>
<img alt="" src="images/orangeSquare.png"><img alt="" src="images/spacer-32.png">
The main application resumes running and shows the results in the "Boxes CRUD (External Client)" window.<br>
<img alt="" src="images/orangeHR-500.png"></P>

<P><img alt="" src="images/BoxesCRUDExternal.png" height="209" width="666"/><br>
<img alt="" src="images/blackArrowUp.png">
<I>Screenshot from "Boxes CRUD (External Client)" action.</I></P>

<a href="#top">Back to the top of the page</a>
<hr>
</BODY>
</HTML>