package com.huoli.checkin.base64;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * base64字符串转图片 <br>
 * 版权: Copyright (c) 2011-2016<br>
 * 公司: 北京活力天汇<br>
 * 
 * @author: 童凡<br>
 * @date: Jul 6, 2016<br>
 */
public class Base64ToImageTest {
	private static Logger logger = LoggerFactory.getLogger(Base64ToImageTest.class);

	@Test
	public void test1() throws IOException {
		String base64String = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAoAGQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDqapW2safe3j2ltdJNMi72CZIxx/F0PUd6u1z9vbW9r41MdvBFCh07JWNAoJ8zrxXonKjoKjuLiK1geedwkSDLMe1SVkazmK7068kV3tIJGMyqpbblflcj0XBOe3ak3ZDiruxasdXsNRd0tLgSOgyV2lTj15HNXa5m+1Kzu7/S7qxDvKLpYjOIiFCngoSRyTnj056V01KLuOUbBVay1C11GOSS0mWZI5DGzKDjcMZwe/UcjisXXdRt7m7/ALDe8itUePfcztKFKpkfIvP3m9/4T0Oab4SntP8AiaW9vLB/x/yvHHGw/wBX8oBAH8Pv0pc3vWM762OlqOaaO3heaZwkaDJY1JXOX13baity73ESxW6yLFEXGZX243Y9PTHP8qVSfIvMG7HQxyJNEksZyjqGU+oNOqnpUkcml23lurbYlVtpzghRwferlVF3SY0FFFFUAVy+/Xf7c/tL+wv+Xb7P5f2tP727Of6YrqKKBphVa9ku4oQ9pAk7hvmjZ9pZeeh6Zzjr2zVmigEZMMF5qN5Dc39uLaO2JMcHmCTe5/iJ6cdu+c1rUUUkrA3cqTaXp9zK0s9hayyN1d4VYnt1IrP8P6R/Z0moSSWkULyXchhZQufJONoBHQcdK26KOVXuKwVn3el2r2U6w2UHmmNgmI1B3Y45rQopSipKzCxV0+2FrYQxeWsbhF3hQOWwMk46n3q1RRTSsrIAooopgFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAH/2Q";
		byte[] data = Base64.decodeBase64(base64String);
		FileUtils.writeByteArrayToFile(new File("target/test.png"), data);
	}

	@Test
	public void test2() throws IOException {
		String base64String = "R0lGODlhPAAUAPAAAP8AAP///ywAAAAAPAAUAEAImQADCBxIsKDBgwgTKlwoEIDDhwAKPlQ4MSHEhg4ZatzIsCJHjBAzDvR4kOTHkyRNShSJ0KPKkyMvwpxJkKXBkBFL2ryZ8aXGlDtX5mzJ0qdQmTGH6sSplKlSmlCXRp1KlSLTmiGlVuVp9anQrTxV4iTqFetYlEDLJu26Fm3ToGbZgvyZ9K3auRYrGj2qlezZuXvBfgwsuPDAgAA7";
		byte[] data = Base64.decodeBase64(base64String);
		logger.debug("{}", new String(data,"GBK"));
	}
}
