/*
 * Copyright 2014 serso aka se.solovyev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Contact details
 *
 * Email: se.solovyev@gmail.com
 * Site:  http://se.solovyev.org
 */

package org.solovyev.android.checkout;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nonnull;

import static java.lang.System.currentTimeMillis;
import static org.solovyev.android.checkout.Billing.DAY;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
abstract class CacheTestBase {

	@Nonnull
	private final AtomicInteger counter = new AtomicInteger();

	@Nonnull
	protected final Cache.Key newKey() {
		return new Cache.Key(counter.getAndIncrement() % RequestType.values().length, "test");
	}

	@Nonnull
	protected final Cache.Entry newEntry() {
		return newEntry(DAY);
	}

	@Nonnull
	protected final Cache.Entry newEntry(long expiresIn) {
		return new Cache.Entry(counter.getAndIncrement(), currentTimeMillis() + expiresIn);
	}

}