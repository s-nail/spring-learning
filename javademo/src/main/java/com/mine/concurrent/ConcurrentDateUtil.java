package com.mine.concurrent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 并发安全的日期格式类
 * 
 * @author    谢朝辉
 * @date      2016-9-7
 */
public class ConcurrentDateUtil {
	public final static String YYYYMMDD = "yyyyMMdd";
	public final static String YYYYMMDDBar = "yyyy-MM-dd";
	public final static String YYYYMMDDBackSlash = "yyyy\\MM\\dd";
	public final static String YYYYMMDDHHMMSS = "yyyyMMdd HHmmss";
	public final static String YYYYMMDDBarHHMMSSColon = "yyyy-MM-dd HH:mm:ss";
	private static int ZONE_OFFSET = Calendar.getInstance().get(Calendar.ZONE_OFFSET);//时间偏移量
	private static int DST_OFFSET = Calendar.getInstance().get(Calendar.DST_OFFSET);//夏令时差
	private static int UTC_OFFSET = ZONE_OFFSET + DST_OFFSET;
	
	
	private static Map<String,ThreadLocal<DateFormat>> dateFormatThreadLocalMap = new HashMap<String, ThreadLocal<DateFormat>>();
	private static ThreadLocal<Calendar> calendarThreadLocal;
	
	static {
		dateFormatThreadLocalMap.put(YYYYMMDD, new ThreadLocal<DateFormat>() {
			@Override
			protected DateFormat initialValue() {
				return new SimpleDateFormat(ConcurrentDateUtil.YYYYMMDD);
			}
		});
		dateFormatThreadLocalMap.put(YYYYMMDDBar, new ThreadLocal<DateFormat>() {
			@Override
			protected DateFormat initialValue() {
				return new SimpleDateFormat(ConcurrentDateUtil.YYYYMMDDBar);
			}
		});
		dateFormatThreadLocalMap.put(YYYYMMDDBackSlash, new ThreadLocal<DateFormat>() {
			@Override
			protected DateFormat initialValue() {
				return new SimpleDateFormat(ConcurrentDateUtil.YYYYMMDDBackSlash);
			}
		});
		dateFormatThreadLocalMap.put(YYYYMMDDHHMMSS, new ThreadLocal<DateFormat>() {
			@Override
			protected DateFormat initialValue() {
				return new SimpleDateFormat(ConcurrentDateUtil.YYYYMMDDHHMMSS);
			}
		});
		dateFormatThreadLocalMap.put(YYYYMMDDBarHHMMSSColon, new ThreadLocal<DateFormat>() {
			@Override
			protected DateFormat initialValue() {
				return new SimpleDateFormat(ConcurrentDateUtil.YYYYMMDDBarHHMMSSColon);
			}
		});
		calendarThreadLocal = new ThreadLocal<Calendar>() {
			@Override
			protected Calendar initialValue() {
				return Calendar.getInstance();
			}
		};
	}
	
	
	/**
	 * 将字符串解析成日期对象
	 * @param format
	 * @param dateStr
	 * @return 字符串对应的日期对象
	 * @throws ParseException 解析出错
     * @exception NullPointerException if the given pattern is null
     * @exception IllegalArgumentException if the given pattern is invalid
	 */
	public static Date parse(String dateStr, String format) throws ParseException {
		if(format == null) {
			throw new NullPointerException("日期格式不能为null");
		}
		ThreadLocal<DateFormat> dateFormat = dateFormatThreadLocalMap.get(format);
		if(dateFormat == null) {
			throw new IllegalArgumentException("日期格式不支持");
		}else {
			return dateFormat.get().parse(dateStr);
		}
	}
	
	/**
	 * 把日期按格式转成字符串
	 * @param format 参考本类的公共常量
	 * @param date
	 * @return 指定格式的字符串
	 */
	public static String format(String format, Date date) {
		return dateFormatThreadLocalMap.get(format).get().format(date);
	}
	
    /**
     * @return 返回 YYYYMMDD格式的当前时间
     */
    public static String getTodayText() {
    	return ConcurrentDateUtil.format(YYYYMMDD, new Date());
    }
    
    public static String getTodayText(String format) {
    	return ConcurrentDateUtil.format(format, new Date());
    }
    
    /**
     * @return 返回 YYYYMMDDBarHHMMSSColon格式的当前时间
     */
    public static String getNowText() {
    	return ConcurrentDateUtil.format(YYYYMMDDBarHHMMSSColon, new Date());
    }
    
    public static String getNowText(String format) {
    	return ConcurrentDateUtil.format(format, new Date());
    }
    
    /**
     * 获取当前utc时间
     */
    public static long getNowUTCTime() {
        Calendar cal = calendarThreadLocal.get();
        cal.add(Calendar.MILLISECOND, -UTC_OFFSET);
        return cal.getTimeInMillis();
    }

    /**
     * 获取utc时间
     */
    public static long getUTCTime(long millis) {
    	Calendar cal = calendarThreadLocal.get();
        cal.setTimeInMillis(millis);
        cal.add(Calendar.MILLISECOND, -UTC_OFFSET);
        return cal.getTimeInMillis();
    }

    /**
     * 根据utc时间，获取当前时间
     */
    public static long convertUTCTime2LocalTime(long millis) {
    	Calendar cal = calendarThreadLocal.get();
        cal.setTimeInMillis(millis);
        cal.add(Calendar.MILLISECOND, UTC_OFFSET);
        return cal.getTimeInMillis();
    }

    /**
     * 将字符串日期转换成指定格式的UTC时间
     */
    public static long convertLocalDateStr2UTCTime(String dateStr, String dateFormat) throws ParseException {
        Date date = parse(dateStr,dateFormat);
        Calendar cal = calendarThreadLocal.get();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.MILLISECOND, -UTC_OFFSET);
        return cal.getTimeInMillis();
    }
    
	public static void main(String[] args) throws ParseException {
//		String dateStr = "2013-03-11 20:55:00";
		Calendar cal = calendarThreadLocal.get();
		cal.setTimeInMillis(1900);
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        System.out.println(zoneOffset);
        System.out.println(dstOffset);
	}
}
