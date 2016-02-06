/*
 * Created By: Abhinav Kumar Mishra
 * Copyright &COPY; 2013-2016.
 * All rights reserved.
 */
package com.abhinav.html.publisher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.abhinav.html.publisher.utils.DirectoryTraverser;
import com.abhinav.html.publisher.utils.HTMLPubUtils;

/**
 * This class HTMLPublishingProcessor<br/> 
 * It will traverse the generated HTML files and prepare an index.html file.
 * 
 * @since 2016
 * @author Abhinav Kumar Mishra
 */
public class HTMLPublishingProcessor {
	
	/**
	 * Publish.
	 *
	 * @param srcPath the src path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void publish(final String srcPath) throws IOException {
		generateIndexReport(DirectoryTraverser.getFileListing(new File(
				HTMLPubUtils.checkLinuxSeperator(srcPath))),srcPath);
	}
	
	/**
	 * Generate index report.
	 *
	 * @param setOfFiles the set of files
	 * @param srcPath the src path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void generateIndexReport(final Set<File> setOfFiles,
			final String srcPath) throws IOException {
		int serNo=HTMLPubUtils.ONE;
		StringBuffer indexBuff = new StringBuffer();
		FileWriter writer = new FileWriter(
				HTMLPubUtils.checkLinuxSeperator(srcPath) + HTMLPubUtils.INDEX);
				
		indexBuff.append("<html><head>\n");
		indexBuff.append("<style> #pagewrap { min-width:78%;margin-left:auto;margin-right: auto; width:1100px;margin: 20px auto 0px;} \n #gradientBoxesWithOuterShadows {height:510px;width: auto;padding: 5px; background-color: lightgray; /* outer shadows  (note the rgba is red, green, blue, alpha) */ -webkit-box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.4);-moz-box-shadow: 0px 1px 6px rgba(23, 69, 88, .5); /* rounded corners */ -webkit-border-radius: 12px; -moz-border-radius: 7px; border-radius: 7px; /* gradients */ /*old color code- #D7E9F5*/ background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, white), color-stop(15%, white), color-stop(100%, #BDBDC9) ); background: -moz-linear-gradient(top, white 0%, white 55%, #BDBDC9 130%}</style>\n");
		indexBuff.append("</head>\n");
		indexBuff.append("<body style='background-color:#EDEDED'><b><p align='center'><u>MyHTML TOC</u></p></b>\n");
		indexBuff.append("<div id='pagewrap'><div id='gradientBoxesWithOuterShadows'>\n");
		indexBuff.append("<span><b>Source Path: </b>");
		indexBuff.append("<a href='file:///" + srcPath
				+ "' target='_blank'>" + srcPath + "</a></span><br/><br/>");
				
		indexBuff.append("<table id='violations' name='violations' style='display:block' width='100%'>\n<tr>\n");
		indexBuff.append("<th align='center' width='8%' height='25%'>SNo.</th>\n");
		indexBuff.append("<th align='center' width='92%' height='25%'>HTML Pages</th>\n");
		indexBuff.append("</table>\n");		
		indexBuff.append("<div align='center' style='overflow:auto;height:350px;'>");
		for (Iterator<File> itr = setOfFiles.iterator(); itr.hasNext();) {	
			String eachEntry=HTMLPubUtils.convertToLinuxFormat(itr.next().getAbsolutePath());
			indexBuff.append("<table id='indexTbl' name='indexTbl' style=\"display:block\" width='100%'>");
			indexBuff.append("<tr>");
			indexBuff.append("<td bgcolor='#9acbcb' align='center' width='8%' height='25%'>"+serNo+"</td>");
			indexBuff.append("<td bgcolor='#9acbcb' width='92%' height='25%' align='center'>");
			indexBuff.append("<a href='./"+ HTMLPubUtils.substringAfterLast(eachEntry)+ "' target='_blank'>"
					+ HTMLPubUtils.substringAfterLast(eachEntry)+ "</a><br/>&nbsp;");
			indexBuff.append("</td>");
			indexBuff.append("</tr></table>");
			serNo++;
		}
		
		indexBuff.append("</div>\n");
        indexBuff.append("</div>");
        indexBuff.append("<p align=\"center\"><i>Developed By: <a href='http://in.linkedin.com/pub/abhinav-kumar-mishra/1b/262/240' target='_blank'>Abhinav Kumar Mishra</a> | Best viewed in IE 9 or above and Google Chrome 20.0 or above</i></p></div>\n");
        indexBuff.append("</body>\n</html>");
        writer.write(indexBuff.toString());
		writer.close();
		System.out.println("[HTMLPublishingProcessor:] HTMLPublisher published the HTMLs..");
	}
}
