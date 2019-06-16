package cn.wolfcode.springboot.utilstest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class StringUtilsTest {

	@Test
	public void test1() {
		// 所有判断方法基本有两个格式，针对String的和针对CharSequence的；

	//判断类型：
	// boolean isEmpty(Object str):字符串是否为空或者空字符串：""
	// boolean hasLength(CharSequence str):字符串是否为空，或者长度为0
	// boolean hasText(String str):字符串是否有内容（不为空，且不全为空格）
	assertFalse(StringUtils.hasText("   "));
	// boolean containsWhitespace(String str):字符串是否包含空格
	assertTrue(StringUtils.containsWhitespace("a b"));
		
		
		
	//字符串头尾操作
	// String trimWhitespace(String str):去掉字符串前后的空格
	assertEquals("abc", StringUtils.trimWhitespace(" abc "));
	// String trimAllWhitespace(String str):去掉字符串中所有的空格
	assertEquals("abc", StringUtils.trimAllWhitespace(" a b c "));
	// String trimLeadingWhitespace(String str):去掉字符串开头的空格
	// String trimTrailingWhitespace(String str):去掉字符串结束的空格

	// String trimLeadingCharacter(String str, char leadingCharacter):去掉字符串开头的指定字符；
	// String trimTrailingCharacter(String str, char trailingCharacter):去掉字符串结尾的指定字符；

	// boolean startsWithIgnoreCase(String str, String prefix):判断字符串是否以指定字符串开头，忽略大小写
	assertTrue(StringUtils.startsWithIgnoreCase("abcd", "AB"));
	// boolean endsWithIgnoreCase(String str, String suffix):判断字符串是否以指定字符串结尾，忽略大小写

		
		
	// 字符串和子串的操作
	// boolean substringMatch(CharSequence str, int index, CharSequence
	// substring):判断从指定索引开始，是否匹配子字符串
	assertTrue(StringUtils.substringMatch("aabbccdd", 1, "abb"));

	// int countOccurrencesOf(String str, String sub):判断子字符串在字符串中出现的次数
	assertEquals(4, StringUtils.countOccurrencesOf("ababaabab", "ab"));

	// String replace(String inString, String oldPattern, String
	// newPattern):在字符串中使用子字符串替换，可以查看源码
	assertEquals("cdcdacdcd", StringUtils.replace("ababaabab", "ab", "cd"));

	// String delete(String inString, String pattern):删除所有匹配的子字符串；
	assertEquals("a", StringUtils.delete("ababaabab", "ab"));

	// String deleteAny(String inString, String charsToDelete):删除子字符串中任意出现的字符
	assertEquals("", StringUtils.deleteAny("ababaabab", "bar"));

	// String quote(String str) :在字符串前后增加单引号,比较适合在日志时候使用；
	assertEquals("'hello'", StringUtils.quote("hello"));
		
		
		
	// 文件路径名称相关操作
	// String unqualify(String qualifiedName):得到以.分割的最后一个值，可以非常方便的获取类似类名或者文件后缀
	assertEquals("java", StringUtils.unqualify("cn.wolfcode.java"));
	assertEquals("java", StringUtils.unqualify("cn/wolfcode/Hello.java"));

	// String unqualify(String qualifiedName, char separator):得到以给定字符分割的最后一个值，可以非常方便的获取类似文件名
	assertEquals("Hello.java", StringUtils
			.unqualify("cn/wolfcode/Hello.java", File.separatorChar));

	// String capitalize(String str):首字母大写
	assertEquals("Wolfcode", StringUtils.capitalize("wolfcode"));

	// String uncapitalize(String str):取消首字母大写
	assertEquals("java", StringUtils.uncapitalize("Java"));

	// String getFilename(String path):获取文件名,就不需要再使用FilenameUtils
	assertEquals("myfile.txt",
			StringUtils.getFilename("mypath/myfile.txt"));

	// String getFilenameExtension(String path):获取文件后缀名
	assertEquals("txt",
			StringUtils.getFilenameExtension("mypath/myfile.txt"));

	// String stripFilenameExtension(String path):截取掉文件路径后缀
	assertEquals("mypath/myfile",
			StringUtils.stripFilenameExtension("mypath/myfile.txt"));

	// String applyRelativePath(String path, String relativePath):找到给定的文件，和另一个相对路径的文件，返回第二个文件的全路径
	// 打印：d:/java/wolfcode/other/Some.java
	System.out.println(StringUtils.applyRelativePath(
			"d:/java/wolfcode/Test.java", "other/Some.java"));
	// 但是不支持重新定位绝对路径和上级目录等复杂一些的相对路径写法：
	// 仍然打印：d:/java/wolfcode/../other/Some.java
	System.out.println(StringUtils.applyRelativePath(
			"d:/java/wolfcode/Test.java", "../other/Some.java"));

	// String cleanPath(String path):清理文件路径,这个方法配合applyRelativePath就可以计算一些简单的相对路径了
	// 打印:d:/java/other/Some.java
	System.out.println(
			StringUtils.cleanPath("d:/java/wolfcode/../other/Some.java"));
	// 需求：获取d:/java/wolfcode/Test.java相对路径为../../other/Some.java的文件全路径：
	// 打印：d:/other/Some.java
	System.out.println(StringUtils.cleanPath(StringUtils.applyRelativePath(
			"d:/java/wolfcode/Test.java", "../../other/Some.java")));

	// boolean pathEquals(String path1, String path2):判断两个文件路径是否相同，会先执行cleanPath之后再比较
	assertTrue(StringUtils.pathEquals("d:/wolfcode.txt",
			"d:/somefile/../wolfcode.txt"));
		
		
		
		
	//本地化相关
	// Locale parseLocaleString(String localeString):从本地化字符串中解析出本地化信息，相当于Locale.toString()的逆向方法
	assertEquals(Locale.CHINA, StringUtils.parseLocaleString("zh_CN"));

	// String toLanguageTag(Locale locale):把Locale转化成HTTP中Accept-Language能接受的本地化标准；
	// 比如标准的本地化字符串为：zh_CN，更改为zh-CN
	System.out.println(StringUtils
			.toLanguageTag(StringUtils.parseLocaleString("zh_CN")));
		
	

	//字符串和Properties
	//Properties splitArrayElementsIntoProperties(String[] array, String delimiter):
	// 把字符串数组中的每一个字符串按照给定的分隔符装配到一个Properties中
	String[] strs=new String[]{"key:value","key2:中文"};
	Properties ps=StringUtils.splitArrayElementsIntoProperties(strs, ":");
	//打印输出：{key=value, key2=中文}
	System.out.println(ps);
	
	//Properties splitArrayElementsIntoProperties(String[] array, String delimiter, String charsToDelete)
	//把字符串数组中的每一个字符串按照给定的分隔符装配到一个Properties中,并删除指定字符串，比如括号之类的
		
		
		
	// String[] addStringToArray(String[] array, String str):把一个字符串添加到一个字符串数组中
	// 打印：[a, b, c, d]
	System.out.println(Arrays.toString(StringUtils
			.addStringToArray(new String[] { "a", "b", "c" }, "d")));

	// String[] concatenateStringArrays(String[] array1, String[]array2):连接两个字符串数组
	//打印：[a, b, c, a, b, c]
	System.out.println(Arrays.toString(StringUtils.concatenateStringArrays(
			new String[] { "a", "b", "c" },
			new String[] { "a", "b", "c","d" })));
	
	//String[] mergeStringArrays(String[] array1, String[] array2)：连接两个字符串数组，去掉重复元素
	//打印：[a, b, c, d]
	System.out.println(Arrays.toString(StringUtils.mergeStringArrays(
			new String[] { "a", "b", "c" },
			new String[] { "a", "b", "c","d" })));
	
	//String[] sortStringArray(String[] array):字符串数组排序
	//打印：[a, b, c, d]
	System.out.println(Arrays.toString(StringUtils.sortStringArray(new String[]{"d","c","b","a"})));
	
	//String[] toStringArray(Collection<String> collection):把字符串集合变成字符串数组
	//String[] toStringArray(Enumeration<String> enumeration):把字符串枚举类型变成字符串数组
	//String[] trimArrayElements(String[] array):把字符串数组中所有字符串执行trim功能；
	//String[] removeDuplicateStrings(String[] array):去掉给定字符串数组中重复的元素，能保持原顺序；
		
		
		
	//String[] split(String toSplit, String delimiter):按照指定字符串分割字符串；
	assertArrayEquals(new String[]{"wolfcode","cn"}, StringUtils.split("wolfcode.cn", "."));
	//只分割第一次，打印：[www, wolfcode.cn]
	System.out.println(Arrays.toString(StringUtils.split("www.wolfcode.cn", ".")));
	
	
	//String[] tokenizeToStringArray(String str, String delimiters)
	//会对每一个元素执行trim操作，并去掉空字符串
	//使用的是StringTokenizer完成，
	//打印[b, c, d]
	System.out.println(Arrays.toString(StringUtils.tokenizeToStringArray("aa,ba,ca,da", "a,")));
	//String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens)
	//后面两个参数在限定是否对每一个元素执行trim操作，是否去掉空字符串
	
	//String[] delimitedListToStringArray(String str, String delimiter):分割字符串，会把delimiter作为整体分隔符
	//打印：[a, b, c, da]
	System.out.println(Arrays.toString(StringUtils.delimitedListToStringArray("aa,ba,ca,da", "a,")));
	//String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete)
	//分割字符串，会把delimiter作为整体分隔符，增加一个要从分割字符串中删除的字符；
	
	//String[] commaDelimitedListToStringArray(String str):使用逗号分割字符串
	//是delimitedListToStringArray(str, ",")的简单方法
	
	//Set<String> commaDelimitedListToSet(String str)：使用逗号分割字符串，并放到set中去重
	//使用LinkedHashSet;
	
	//String collectionToDelimitedString(Collection<?> coll, String delim, String prefix, String suffix)
	//将一个集合中的元素，使用前缀，后缀，分隔符拼装一个字符串，前缀后后缀是针对每一个字符串的
	String[] arrs=new String[]{"aa","bb","cc","dd"};
	assertEquals("{aa},{bb},{cc},{dd}", StringUtils.collectionToDelimitedString(Arrays.asList(arrs),",","{","}"));
	
	//String collectionToDelimitedString(Collection<?> coll, String delim)：集合变成指定字符串连接的字符串；
	//是collectionToDelimitedString(coll, delim, "", "")的简写；
	//String collectionToCommaDelimitedString(Collection<?> coll)：集合变成逗号连接的字符串；
	//是collectionToDelimitedString(coll, ",");的简写；
	
	//String arrayToDelimitedString(Object[] arr, String delim)：数组使用指定字符串连接；
	//String arrayToCommaDelimitedString(Object[] arr)：使用逗号连接数组，拼成字符串；
		
	}
}
