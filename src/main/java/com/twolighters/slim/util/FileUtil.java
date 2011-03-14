package com.twolighters.slim.util;

import java.io.File;

public class FileUtil
{
	/**
     * Obtained from: http://www.rgagnon.com/javadetails/java-0483.html
     *
     * Need to do this to delete a non-empty directory.
     *
     * @param path
     * @return
     */
    public static boolean deleteDirectory(File path)
    {
        if (path.exists())
        {
                File[] files = path.listFiles();
                boolean b = true;
                for (int i = 0; i < files.length && b; i++)
                {
                        if (files[i].isDirectory())
                        {
                                deleteDirectory(files[i]);
                        }
                        else
                        {
                                b = files[i].delete();
                        }
                }
        }
        return (path.delete());
    }
}
