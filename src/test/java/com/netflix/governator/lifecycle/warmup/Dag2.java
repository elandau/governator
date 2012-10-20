package com.netflix.governator.lifecycle.warmup;

import com.google.inject.Inject;
import com.netflix.governator.annotations.WarmUp;

public class Dag2
{
    /*
        3 tiers of classes all with warmups

             B1
           <    >
        A1        C1
           <    >
             B2
           <    >
        A2        C2
           <    >
             B3
           <    >
        A3        C3
           <    >
             B4
     */

    public static class C1
    {
        private final Recorder recorder;

        @Inject
        public C1(Recorder recorder)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("C1");
        }
    }

    public static class C2
    {
        private final Recorder recorder;

        @Inject
        public C2(Recorder recorder)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("C2");
        }
    }

    public static class C3
    {
        private final Recorder recorder;

        @Inject
        public C3(Recorder recorder)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("C3");
        }
    }

    @SuppressWarnings("UnusedParameters")
    public static class B1
    {
        private final Recorder recorder;

        @Inject
        public B1(Recorder recorder, C1 c1)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("B1");
        }
    }

    @SuppressWarnings("UnusedParameters")
    public static class B2
    {
        private final Recorder recorder;

        @Inject
        public B2(Recorder recorder, C1 c1, C2 c2)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("B2");
        }
    }

    @SuppressWarnings("UnusedParameters")
    public static class B3
    {
        private final Recorder recorder;

        @Inject
        public B3(Recorder recorder, C2 c2, C3 c3)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("B3");
        }
    }

    @SuppressWarnings("UnusedParameters")
    public static class B4
    {
        private final Recorder recorder;

        @Inject
        public B4(Recorder recorder, C3 c3)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("B4");
        }
    }

    @SuppressWarnings("UnusedParameters")
    public static class A1
    {
        private final Recorder recorder;

        @Inject
        public A1(Recorder recorder, B1 b1, B2 b2)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("A1");
        }
    }

    @SuppressWarnings("UnusedParameters")
    public static class A2
    {
        private final Recorder recorder;

        @Inject
        public A2(Recorder recorder, B2 b2, B3 b3)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("A2");
        }
    }

    @SuppressWarnings("UnusedParameters")
    public static class A3
    {
        private final Recorder recorder;

        @Inject
        public A3(Recorder recorder, B3 b3, B4 b4)
        {
            this.recorder = recorder;
        }

        @WarmUp
        public void warmUp() throws InterruptedException
        {
            recorder.record("A3");
        }
    }
}
