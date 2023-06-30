package net.openrs.cache.sound;

import net.openrs.util.ByteBufferUtils;

import java.nio.ByteBuffer;
import java.util.Random;

public class AudioInstrument {

    static int[] samples;
    static int[] NOISE = new int[32768];
    static int[] AUDIO_SINE = new int[32768];
    static int[] phases;
    static int[] delays;
    static int[] volumeSteps;
    static int[] pitchSteps;
    static int[] pitchBaseSteps;

    AudioEnvelope pitch;
    AudioEnvelope volume;
    AudioEnvelope pitchModifier;
    AudioEnvelope pitchModifierAmplitude;
    AudioEnvelope volumeMultiplier;
    AudioEnvelope volumeMultiplierAmplitude;
    AudioEnvelope release;
    AudioEnvelope field1653;

    int[] oscillatorVolume;
    int[] oscillatorPitch;
    int[] oscillatorDelays;
    int delayTime;
    int delayDecay;
    SoundEffect3 filter;
    AudioEnvelope filterEnvelope;

    int duration;
    int offset;

    static {
        Random var0 = new Random(0L);

        int var1;
        for(var1 = 0; var1 < 32768; ++var1) {
            NOISE[var1] = (var0.nextInt() & 2) - 1;
        }

        for(var1 = 0; var1 < 32768; ++var1) {
            AUDIO_SINE[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
        }

        samples = new int[220500];
        phases = new int[5];
        delays = new int[5];
        volumeSteps = new int[5];
        pitchSteps = new int[5];
        pitchBaseSteps = new int[5];
    }

    AudioInstrument() {
        this.oscillatorVolume = new int[]{0, 0, 0, 0, 0};
        this.oscillatorPitch = new int[]{0, 0, 0, 0, 0};
        this.oscillatorDelays = new int[]{0, 0, 0, 0, 0};
        this.delayTime = 0;
        this.delayDecay = 100;
        this.duration = 500;
        this.offset = 0;
    }

    private static void method3854(int[] var0, int var1, int var2) {
        for(var2 = var2 + var1 - 7; var1 < var2; var0[var1++] = 0) {
            var0[var1++] = 0;
            var0[var1++] = 0;
            var0[var1++] = 0;
            var0[var1++] = 0;
            var0[var1++] = 0;
            var0[var1++] = 0;
            var0[var1++] = 0;
        }

        for(var2 += 7; var1 < var2; var0[var1++] = 0) {
            ;
        }

    }

    final int[] synthesize(int var1, int var2) {
        method3854(samples, 0, var1);
        if(var2 < 10) {
            return samples;
        } else {
            double var3 = (double)var1 / ((double)var2 + 0.0D);
            this.pitch.reset();
            this.volume.reset();
            int var5 = 0;
            int var6 = 0;
            int var7 = 0;
            if(this.pitchModifier != null) {
                this.pitchModifier.reset();
                this.pitchModifierAmplitude.reset();
                var5 = (int)((double)(this.pitchModifier.end - this.pitchModifier.start) * 32.768D / var3);
                var6 = (int)((double)this.pitchModifier.start * 32.768D / var3);
            }

            int var8 = 0;
            int var9 = 0;
            int var10 = 0;
            if(this.volumeMultiplier != null) {
                this.volumeMultiplier.reset();
                this.volumeMultiplierAmplitude.reset();
                var8 = (int)((double)(this.volumeMultiplier.end - this.volumeMultiplier.start) * 32.768D / var3);
                var9 = (int)((double)this.volumeMultiplier.start * 32.768D / var3);
            }

            int var11;
            for(var11 = 0; var11 < 5; ++var11) {
                if(this.oscillatorVolume[var11] != 0) {
                    phases[var11] = 0;
                    delays[var11] = (int)((double)this.oscillatorDelays[var11] * var3);
                    volumeSteps[var11] = (this.oscillatorVolume[var11] << 14) / 100;
                    pitchSteps[var11] = (int)((double)(this.pitch.end - this.pitch.start) * 32.768D * Math.pow(1.0057929410678534D, (double)this.oscillatorPitch[var11]) / var3);
                    pitchBaseSteps[var11] = (int)((double)this.pitch.start * 32.768D / var3);
                }
            }

            int var12;
            int var13;
            int var14;
            int var15;
            for(var11 = 0; var11 < var1; ++var11) {
                var12 = this.pitch.step(var1);
                var13 = this.volume.step(var1);
                if(this.pitchModifier != null) {
                    var14 = this.pitchModifier.step(var1);
                    var15 = this.pitchModifierAmplitude.step(var1);
                    var12 += this.evaluateWave(var7, var15, this.pitchModifier.form) >> 1;
                    var7 = var7 + var6 + (var14 * var5 >> 16);
                }

                if(this.volumeMultiplier != null) {
                    var14 = this.volumeMultiplier.step(var1);
                    var15 = this.volumeMultiplierAmplitude.step(var1);
                    var13 = var13 * ((this.evaluateWave(var10, var15, this.volumeMultiplier.form) >> 1) + 32768) >> 15;
                    var10 = var10 + var9 + (var14 * var8 >> 16);
                }

                for(var14 = 0; var14 < 5; ++var14) {
                    if(this.oscillatorVolume[var14] != 0) {
                        var15 = delays[var14] + var11;
                        if(var15 < var1) {
                            samples[var15] += this.evaluateWave(phases[var14], var13 * volumeSteps[var14] >> 15, this.pitch.form);
                            phases[var14] += (var12 * pitchSteps[var14] >> 16) + pitchBaseSteps[var14];
                        }
                    }
                }
            }

            int var16;
            if(this.release != null) {
                this.release.reset();
                this.field1653.reset();
                var11 = 0;
                boolean var19 = false;
                boolean var20 = true;

                for(var14 = 0; var14 < var1; ++var14) {
                    var15 = this.release.step(var1);
                    var16 = this.field1653.step(var1);
                    if(var20) {
                        var12 = (var15 * (this.release.end - this.release.start) >> 8) + this.release.start;
                    } else {
                        var12 = (var16 * (this.release.end - this.release.start) >> 8) + this.release.start;
                    }

                    var11 += 256;
                    if(var11 >= var12) {
                        var11 = 0;
                        var20 = !var20;
                    }

                    if(var20) {
                        samples[var14] = 0;
                    }
                }
            }

            if(this.delayTime > 0 && this.delayDecay > 0) {
                var11 = (int)((double)this.delayTime * var3);

                for(var12 = var11; var12 < var1; ++var12) {
                    samples[var12] += samples[var12 - var11] * this.delayDecay / 100;
                }
            }

            if(this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
                this.filterEnvelope.reset();
                var11 = this.filterEnvelope.step(var1 + 1);
                var12 = this.filter.compute(0, (float)var11 / 65536.0F);
                var13 = this.filter.compute(1, (float)var11 / 65536.0F);
                if(var1 >= var12 + var13) {
                    var14 = 0;
                    var15 = var13;
                    if(var13 > var1 - var12) {
                        var15 = var1 - var12;
                    }

                    int var17;
                    while(var14 < var15) {
                        var16 = (int)((long)samples[var14 + var12] * (long)SoundEffect3.fowardMultiplier >> 16);

                        for(var17 = 0; var17 < var12; ++var17) {
                            var16 += (int)((long)samples[var14 + var12 - 1 - var17] * (long)SoundEffect3.coefficients[0][var17] >> 16);
                        }

                        for(var17 = 0; var17 < var14; ++var17) {
                            var16 -= (int)((long)samples[var14 - 1 - var17] * (long)SoundEffect3.coefficients[1][var17] >> 16);
                        }

                        samples[var14] = var16;
                        var11 = this.filterEnvelope.step(var1 + 1);
                        ++var14;
                    }

                    var15 = 128;

                    while(true) {
                        if(var15 > var1 - var12) {
                            var15 = var1 - var12;
                        }

                        int var18;
                        while(var14 < var15) {
                            var17 = (int)((long)samples[var14 + var12] * (long)SoundEffect3.fowardMultiplier >> 16);

                            for(var18 = 0; var18 < var12; ++var18) {
                                var17 += (int)((long)samples[var14 + var12 - 1 - var18] * (long)SoundEffect3.coefficients[0][var18] >> 16);
                            }

                            for(var18 = 0; var18 < var13; ++var18) {
                                var17 -= (int)((long)samples[var14 - 1 - var18] * (long)SoundEffect3.coefficients[1][var18] >> 16);
                            }

                            samples[var14] = var17;
                            var11 = this.filterEnvelope.step(var1 + 1);
                            ++var14;
                        }

                        if(var14 >= var1 - var12) {
                            while(var14 < var1) {
                                var17 = 0;

                                for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                                    var17 += (int)((long)samples[var14 + var12 - 1 - var18] * (long)SoundEffect3.coefficients[0][var18] >> 16);
                                }

                                for(var18 = 0; var18 < var13; ++var18) {
                                    var17 -= (int)((long)samples[var14 - 1 - var18] * (long)SoundEffect3.coefficients[1][var18] >> 16);
                                }

                                samples[var14] = var17;
                                this.filterEnvelope.step(var1 + 1);
                                ++var14;
                            }
                            break;
                        }

                        var12 = this.filter.compute(0, (float)var11 / 65536.0F);
                        var13 = this.filter.compute(1, (float)var11 / 65536.0F);
                        var15 += 128;
                    }
                }
            }

            for(var11 = 0; var11 < var1; ++var11) {
                if(samples[var11] < -32768) {
                    samples[var11] = -32768;
                }

                if(samples[var11] > 32767) {
                    samples[var11] = 32767;
                }
            }

            return samples;
        }
    }

    final int evaluateWave(int var1, int var2, int var3) {
        return var3 == 1?((var1 & 32767) < 16384?var2:-var2):(var3 == 2?AUDIO_SINE[var1 & 32767] * var2 >> 14:(var3 == 3?(var2 * (var1 & 32767) >> 14) - var2:(var3 == 4?var2 * NOISE[var1 / 2607 & 32767]:0)));
    }

    final void decode(ByteBuffer var1) {
        this.pitch = new AudioEnvelope();
        this.pitch.decode(var1);
        this.volume = new AudioEnvelope();
        this.volume.decode(var1);
        int var2 = var1.get() & 0xFF;
        if(var2 != 0) {
            var1.position(var1.position() - 1);
            this.pitchModifier = new AudioEnvelope();
            this.pitchModifier.decode(var1);
            this.pitchModifierAmplitude = new AudioEnvelope();
            this.pitchModifierAmplitude.decode(var1);
        }

        var2 = var1.get() & 0xFF;
        if(var2 != 0) {
            var1.position(var1.position() - 1);
            this.volumeMultiplier = new AudioEnvelope();
            this.volumeMultiplier.decode(var1);
            this.volumeMultiplierAmplitude = new AudioEnvelope();
            this.volumeMultiplierAmplitude.decode(var1);
        }

        var2 = var1.get() & 0xFF;
        if(var2 != 0) {
            var1.position(var1.position() - 1);
            this.release = new AudioEnvelope();
            this.release.decode(var1);
            this.field1653 = new AudioEnvelope();
            this.field1653.decode(var1);
        }

        for(int var3 = 0; var3 < 10; ++var3) {
            int var4 = ByteBufferUtils.getUnsignedSmart(var1);

            if(var4 == 0) {
                break;
            }

            this.oscillatorVolume[var3] = var4;
            this.oscillatorPitch[var3] = ByteBufferUtils.getSignedSmart(var1);
            this.oscillatorDelays[var3] = ByteBufferUtils.getUnsignedSmart(var1);
        }

        this.delayTime = ByteBufferUtils.getUnsignedSmart(var1);
        this.delayDecay = ByteBufferUtils.getUnsignedSmart(var1);
        this.duration = var1.getShort() & 0xFFFF;
        this.offset = var1.getShort() & 0xFFFF;
        this.filter = new SoundEffect3();
        this.filterEnvelope = new AudioEnvelope();
        this.filter.decode(var1, this.filterEnvelope);
    }

}
