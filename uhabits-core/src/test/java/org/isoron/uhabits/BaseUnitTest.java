/*
 * Copyright (C) 2017 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits;

import org.isoron.uhabits.core.commands.*;
import org.isoron.uhabits.core.models.*;
import org.isoron.uhabits.core.models.memory.*;
import org.isoron.uhabits.core.tasks.*;
import org.isoron.uhabits.core.test.*;
import org.isoron.uhabits.core.utils.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.junit.*;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BaseUnitTest
{

    protected HabitList habitList;

    protected HabitFixtures fixtures;

    protected MemoryModelFactory modelFactory;

    protected SingleThreadTaskRunner taskRunner;

    protected CommandRunner commandRunner;

    // 8:00am, January 25th, 2015 (UTC)
    protected static final long FIXED_LOCAL_TIME = 1422172800000L;

    @Before
    public void setUp()
    {
        DateUtils.setFixedLocalTime(FIXED_LOCAL_TIME);

        modelFactory = new MemoryModelFactory();
        habitList = spy(modelFactory.buildHabitList());
        fixtures = new HabitFixtures(modelFactory);
        taskRunner = new SingleThreadTaskRunner();
        commandRunner = new CommandRunner(taskRunner);
    }

    @After
    public void tearDown()
    {
        validateMockitoUsage();
        DateUtils.setFixedLocalTime(null);
    }

    public long timestamp(int year, int month, int day)
    {
        GregorianCalendar cal = DateUtils.getStartOfTodayCalendar();
        cal.set(year, month, day);
        return cal.getTimeInMillis();
    }

    @Test
    public void nothing()
    {

    }
}
