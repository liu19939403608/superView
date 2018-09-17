package com.asuper.superview.util;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class stringCut {

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(long specifiedDay) {
        // SimpleDateFormat simpleDateFormat = new
        // SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date = null;
//		try {
        date = new Date(specifiedDay);
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
//			return sf.format(d);
//			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayAfter(long specifiedDay) {
        // SimpleDateFormat simpleDateFormat = new
        // SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date = null;
//		try {
        date = new Date(specifiedDay);
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
//			return sf.format(d);
//			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    public static String getSpecifiedDay(long specifiedDay) {
        long dayDiff = 1;
        //当前时间处理
        Calendar cal = Calendar.getInstance();
        dayDiff = (specifiedDay - cal.getTimeInMillis()) / (1000 * 60 * 60);
        if (dayDiff > 24) {
            return (dayDiff / 24) + "天";
        } else if (dayDiff <= 0) {
            return "已结束";
        }
        return dayDiff + "小时";
    }

    // 空格转换
    public static String space_Cut(String string_cut) {
        String tmpstr = string_cut.replace(" ", "");
        return tmpstr;
    }

    // ,转换
    public static String douHao_Cut(String string_cut) {
        String tmpstr = string_cut.replace(",", "");
        return tmpstr;
    }

    // 手机号截取
    public static String phoneCut(String string_cut) {
        String string = "";
        if (string_cut != null && !string_cut.equalsIgnoreCase("")) {

            string = string_cut.substring(0, 3);
            string += "****" + string_cut.substring(7, 11);
        }
        return string;
    }

    // 时间轴转换成日期
    public static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    // 返回日期
    public static Date getDate(long time) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sf.format(time);
        Date d = sf.parse(s);
        return d;
    }

    public static String getNumKb(double s) {
        NumberFormat formatter = new DecimalFormat("#,##0.00");
        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(s);
    }


    public static String getDoubleKb(double s) {
        NumberFormat formatter = new DecimalFormat("###0.##");
        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(s);
    }

    public static String getNumKbs(double s) {
        NumberFormat formatter = new DecimalFormat("#,##0.##");
        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(s);
    }

    // 时间轴转换成日期(带时分秒)
    public static String getDateTimeToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd\nHH:mm:ss");
        return sf.format(d);
    }

    // 时间轴转换成日期(带时分秒)横向显示
    public static String getDateTimeToStringheng(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return sf.format(d);
    }

    // 时间轴转换成日期(年、月、日)
    public static String getDateYearToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    // 时间轴转换成日期(时、分)
    public static String getDateHourToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        return sf.format(d);
    }

    // 手机号截取
    public static String pertCut(String string_cut) {
        String string = "";
        if (Double.parseDouble(string_cut) == 0) {
            string = "0";
            return string;
        } else if (Double.parseDouble(string_cut) > 0
                && Double.parseDouble(string_cut) < 1) {
            string = "1";
            return string;
        } else if (Double.parseDouble(string_cut) > 99
                && Double.parseDouble(string_cut) < 100) {
            string = "99";
            return string;
        }
        int string_cut_int;
        try {
            string_cut_int = Integer.parseInt(string_cut, 10);
        } catch (Exception nbFmtExp) {
            string_cut_int = (int) (Float.parseFloat(string_cut) / 1);// 也可以直接强制转换i
            // =
            // (int)(Float.parseFloat(s));//
        }
        return string.valueOf(string_cut_int);
    }

    // 数组转string
    public static String listToString(List<String> list_message_ID) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list_message_ID.size(); i++) {
            buffer.append(list_message_ID.get(i));
            if (i < list_message_ID.size() - 1) {
                buffer.append(",");
            }
        }
        return buffer.toString();
    }

    // 密码格式判断
    public static Boolean isPsw(String string_cut) {
        String string = "";
        Pattern psw = Pattern.compile("^[a-zA-Z0-9]{6,18}$");
        Pattern pswNum = Pattern.compile("^[0-9]*$"); // 判断纯数字
        Pattern pswAbc = Pattern.compile("^[a-zA-Z]*$"); // 判断纯字母
        Matcher mPsw = psw.matcher(string_cut);
        Matcher mpswNum = pswNum.matcher(string_cut);
        Matcher mpswAbc = pswAbc.matcher(string_cut);

        if (mPsw.matches()) {
            if (mpswNum.matches() || mpswAbc.matches()) {
                return false;
            }
            return true;
        }
        return false;
    }

    // 版本判断
    public static int compareVersion(String version1, String version2) {
        String[] versionArray1 = version1.split("\\.");// 注意此处为正则匹配，不能用"."；
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);// 取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length()
                - versionArray2[idx].length()) == 0// 先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {// 再比较字符
            ++idx;
        }
        // 如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }

    public static Boolean versionMaxOr(String maxVersion, String localVersion) {
        int string_length = maxVersion.split("\\.").length;
        if (maxVersion.split("\\.").length > localVersion.split("\\.").length) {
            return true;
        }
        for (int i = 0; i < string_length; i++) {
            if (i == 0 || i == 1) {
                if (Double.valueOf(maxVersion.split("\\.")[i]) > Double
                        .valueOf(localVersion.split("\\.")[i])) {
                    return true;
                } else if (Double.valueOf(maxVersion.split("\\.")[i]) < Double
                        .valueOf(localVersion.split("\\.")[i])) {
                    return false;
                }
            } else {
                if (Double.valueOf(maxVersion.split("\\.")[i]) > Double
                        .valueOf(localVersion.split("\\.")[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    // ,转换
    public static String HuanHang_Cut(String string_cut) {
        String tmpstr = string_cut.replace("^", "\n");
        return tmpstr;
    }

    static char[] numArray = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};

    public static String formatFractionalPart(int decimal) {
        char[] val = String.valueOf(decimal).toCharArray();
        int len = val.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int n = Integer.valueOf(val[i] + "");
            sb.append(numArray[n]);
        }
        return sb.toString();
    }



    public static boolean isEmpty(String str) {
        if (str != null && !"".equalsIgnoreCase(str)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        if (isEmpty(str)) {
            return false;
        } else {
            String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(str);
            return m.matches();
        }
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public static boolean isHKPhoneLegal(String str) throws PatternSyntaxException {
        if (isEmpty(str)) {
            return false;
        } else {
            String regExp = "^(5|6|8|9)\\d{7}$";
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(str);
            return m.matches();
        }
    }

    /**
     * 判断是否包含表情
     *
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        boolean isEmoji = false;
        for (int i = 0; i < len; i++) {
            char hs = source.charAt(i);
            if (0xd800 <= hs && hs <= 0xdbff) {
                if (source.length() > 1) {
                    char ls = source.charAt(i + 1);
                    int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;
                    if (0x1d000 <= uc && uc <= 0x1f77f) {
                        return true;
                    }
                }
            } else {
                // non surrogate
                if (0x2100 <= hs && hs <= 0x27ff && hs != 0x263b) {
                    return true;
                } else if (0x2B05 <= hs && hs <= 0x2b07) {
                    return true;
                } else if (0x2934 <= hs && hs <= 0x2935) {
                    return true;
                } else if (0x3297 <= hs && hs <= 0x3299) {
                    return true;
                } else if (hs == 0xa9 || hs == 0xae || hs == 0x303d
                        || hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c
                        || hs == 0x2b1b || hs == 0x2b50 || hs == 0x231a) {
                    return true;
                }
                if (!isEmoji && source.length() > 1 && i < source.length() - 1) {
                    char ls = source.charAt(i + 1);
                    if (ls == 0x20e3) {
                        return true;
                    }
                }
            }
        }
        return isEmoji;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

}
