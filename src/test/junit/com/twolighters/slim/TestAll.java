package com.twolighters.slim;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.twolighters.slim.command.TestCreateCommandViaFullRun;
import com.twolighters.slim.command.TestDeleteCommandViaFullRun;
import com.twolighters.slim.command.TestExecuteCommandViaFullRun;
import com.twolighters.slim.command.TestGetCommandViaFullRun;
import com.twolighters.slim.command.builder.TestCreateCommandBuilder;
import com.twolighters.slim.command.builder.TestDeleteCommandBuilder;
import com.twolighters.slim.command.builder.TestExecuteCommandBuilder;
import com.twolighters.slim.command.builder.TestGetCommandBuilder;
import com.twolighters.slim.node.TestReplacementStrategy;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestSlim.class,
    TestCreateCommandViaFullRun.class,
    TestDeleteCommandViaFullRun.class,
    TestExecuteCommandViaFullRun.class,
    TestGetCommandViaFullRun.class,
    TestCreateCommandBuilder.class,
    TestDeleteCommandBuilder.class,
    TestExecuteCommandBuilder.class,
    TestGetCommandBuilder.class,
    TestReplacementStrategy.class
    })
public class TestAll
{
}
