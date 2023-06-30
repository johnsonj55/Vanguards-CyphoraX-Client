package com.client;

import java.math.BigInteger;

import com.client.sign.Signlink;

public final class Buffer extends Cacheable {

    public int read24Int() {
        currentPosition += 3;
        return ((payload[currentPosition - 3] & 0xff) << 16) + ((payload[currentPosition - 2] & 0xff) << 8) + (payload[currentPosition - 1] & 0xff);
    }


    private static final BigInteger RSA_MODULUS = new BigInteger("91520827044808581871318118254770120611343888611033050838722939781067880678552781697572245594439341402118233490664238364235358342012694177068230893936750633213888618825951425602731544513980715835301977356001573144440585484179765317637775760229380331179714685593753856711452802805126498363795384945303137663457");
    private static final BigInteger RSA_EXPONENT = new BigInteger("65537");

    public static Buffer create() {
        synchronized (nodeList) {
            Buffer stream = null;
            if (anInt1412 > 0) {
                anInt1412--;
                stream = (Buffer) nodeList.popHead();
            }
            if (stream != null) {
                stream.currentPosition = 0;
                return stream;
            }
        }
        Buffer stream_1 = new Buffer();
        stream_1.currentPosition = 0;
        stream_1.payload = new byte[RSSocket.SIZE];
        return stream_1;
    }

    public int getSmart() {
        try {
            // checks current without modifying position
            if (currentPosition >= payload.length) {
                return payload[payload.length - 1] & 0xFF;
            }
            int value = payload[currentPosition] & 0xFF;

            if (value < 128) {
                return readUnsignedByte();
            } else {
                return readUShortA() - 32768;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return readUShortA() - 32768;
        }
    }

    public static Buffer create(int initialCapacity) {
        synchronized (nodeList) {
            Buffer stream = null;
            if (anInt1412 > 0) {
                anInt1412--;
                stream = (Buffer) nodeList.popHead();
            }
            if (stream != null) {
                stream.currentPosition = 0;
                return stream;
            }
        }
        Buffer stream_1 = new Buffer();
        stream_1.currentPosition = 0;
        stream_1.payload = new byte[initialCapacity];
        return stream_1;
    }

    public Buffer() {
    }

    public byte[] getData(byte[] buffer2) {
        for (int i = 0; i < buffer2.length; i++)
            buffer2[i] = payload[currentPosition++];
        return buffer2;
    }

    public Buffer(byte abyte0[]) {
        payload = abyte0;
        currentPosition = 0;
    }

    public void createFrame(int i) {
        if (Configuration.developerMode)
            Client.instance.devConsole.print_message("Outgoing Packet " + i, 0);
        payload[currentPosition++] = (byte) (i + encryption.getNextKey());
    }

    public void writeUnsignedByte(int i) {
        payload[currentPosition++] = (byte) i;
    }

    final int v(int i) {
        currentPosition += 3;
        return (0xff & payload[currentPosition - 3] << 16)
                + (0xff & payload[currentPosition - 2] << 8)
                + (0xff & payload[currentPosition - 1]);
    }

    public int readUnsignedByte2() {
        return -263;
    }

    public int g2() {
        currentPosition += 2;
        return ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
    }

    public int g4() {
        currentPosition += 4;
        return ((payload[currentPosition - 4] & 0xff) << 24)
                + ((payload[currentPosition - 3] & 0xff) << 16)
                + ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
    }

    public int readShort2() {
        currentPosition += 2;
        int i = ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
        if (i > 60000)
            i = -65535 + i;
        return i;

    }

    public int readUSmart2() {
        int baseVal = 0;
        int lastVal = 0;
        while ((lastVal = readSmart()) == 32767) {
            baseVal += 32767;
        }
        return baseVal + lastVal;
    }

    public int readShort() {
        currentPosition += 2;
        int value = ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);

        if (value > 32767) {
            value -= 0x10000;
        }
        return value;
    }

    public String readNewString() {
        int i = currentPosition;
        while (payload[currentPosition++] != 0)
            ;
        return new String(payload, i, currentPosition - i - 1);
    }

    public void writeWord(int i) {
        payload[currentPosition++] = (byte) (i >> 8);
        payload[currentPosition++] = (byte) i;
    }

    public void method400(int i) {
        payload[currentPosition++] = (byte) i;
        payload[currentPosition++] = (byte) (i >> 8);
    }

    public void writeDWordBigEndian(int i) {
        payload[currentPosition++] = (byte) (i >> 16);
        payload[currentPosition++] = (byte) (i >> 8);
        payload[currentPosition++] = (byte) i;
    }

    public void writeDWord(int i) {
        payload[currentPosition++] = (byte) (i >> 24);
        payload[currentPosition++] = (byte) (i >> 16);
        payload[currentPosition++] = (byte) (i >> 8);
        payload[currentPosition++] = (byte) i;
    }

    public void method403(int j) {
        payload[currentPosition++] = (byte) j;
        payload[currentPosition++] = (byte) (j >> 8);
        payload[currentPosition++] = (byte) (j >> 16);
        payload[currentPosition++] = (byte) (j >> 24);
    }

    public void writeQWord(long l) {
        try {
            payload[currentPosition++] = (byte) (int) (l >> 56);
            payload[currentPosition++] = (byte) (int) (l >> 48);
            payload[currentPosition++] = (byte) (int) (l >> 40);
            payload[currentPosition++] = (byte) (int) (l >> 32);
            payload[currentPosition++] = (byte) (int) (l >> 24);
            payload[currentPosition++] = (byte) (int) (l >> 16);
            payload[currentPosition++] = (byte) (int) (l >> 8);
            payload[currentPosition++] = (byte) (int) l;
        } catch (RuntimeException runtimeexception) {
            Signlink.reporterror("14395, " + 5 + ", " + l + ", "
                    + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void writeString(String s) {
        System.arraycopy(s.getBytes(), 0, payload, currentPosition, s.length());
        currentPosition += s.length();
        payload[currentPosition++] = 10;
    }


	public void writeWordBigEndian(int i) {
		payload[currentPosition++] = (byte) i;
	}

    public void writeBytes(byte abyte0[], int length, int startingPosition) {
        for (int k = startingPosition; k < startingPosition + length; k++)
            payload[currentPosition++] = abyte0[k];
    }

    public void writeHiddenString(String string) {
        writeByte(string.length());
        byte[] stringBytes = string.getBytes();
        for (int index = 0; index < stringBytes.length; index++)
            stringBytes[index] += 15;
        writeBytes(stringBytes, stringBytes.length, 0);
    }

    public String readHiddenString() {
        int length = readUnsignedByte();
        byte[] stringBytes = new byte[length];
        for (int index = 0; index < length; index++) {
            stringBytes[index] = (byte) (readUnsignedByte() - 15);
        }
        return new String(stringBytes);
    }

    public void writeByte(int i) {
        payload[currentPosition++] = (byte) i;
    }

    public void writeBytes(int i) {
        payload[currentPosition - i - 1] = (byte) i;
    }

    public int read24BitInt()
    {
        return (this.readUnsignedByte() << 16) + (this.readUnsignedByte() << 8) + this.readUnsignedByte();
    }

    public int readUnsignedByte() {
        return payload[currentPosition++] & 0xff;
    }

    public byte readSignedByte() {
        return payload[currentPosition++];
    }

    public int readTriByte() {
        currentPosition += 3;
        return ((payload[currentPosition - 3] & 0xff) << 16)
                + ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
    }


    public int readUShort() {
        currentPosition += 2;
        return ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
    }

    public int method1606() {
        int var2 = 0;

        int var3;
        for (var3 = this.readUShortSmart(); var3 == 32767; var3 = this.readUShortSmart()) {
            var2 += 32767;
        }

        var2 += var3;
        return var2;
    }

    public int readUShortSmart() {
        int var2 = this.payload[this.currentPosition] & 255;
        return var2 < 128 ? this.readUnsignedByte() : this.readUShort() - 32768;
    }

    public int readSignedWord() {
        currentPosition += 2;
        int i = ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
        if (i > 32767)
            i -= 0x10000;
        return i;
    }

    public int read3Bytes() {
        currentPosition += 3;
        return ((payload[currentPosition - 3] & 0xff) << 16)
                + ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
    }

    public int readDWord() {
        currentPosition += 4;
        return ((payload[currentPosition - 4] & 0xff) << 24)
                + ((payload[currentPosition - 3] & 0xff) << 16)
                + ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] & 0xff);
    }

    public long readQWord() {
        long l = readDWord() & 0xffffffffL;
        long l1 = readDWord() & 0xffffffffL;
        return (l << 32) + l1;
    }

    public String readString() {
        int i = currentPosition;
        while (payload[currentPosition++] != 10)
            ;
        return new String(payload, i, currentPosition - i - 1);
    }

    public String readNullTerminatedString() {
        int i = currentPosition;
        while (payload[currentPosition++] != 0)
            ;
        return new String(payload, i, currentPosition - i - 1);
    }

    private static final char[] OSRS_CHARACTERS = new char[]
            {
                    '\u20ac', '\u0000', '\u201a', '\u0192', '\u201e', '\u2026',
                    '\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039',
                    '\u0152', '\u0000', '\u017d', '\u0000', '\u0000', '\u2018',
                    '\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014',
                    '\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\u0000',
                    '\u017e', '\u0178'
            };

    public String readOSRSString()
    {
        StringBuilder sb = new StringBuilder();

        for (; ; )
        {
            int ch = this.readUnsignedByte();

            if (ch == 0)
            {
                break;
            }

            if (ch >= 128 && ch < 160)
            {
                char var7 = OSRS_CHARACTERS[ch - 128];
                if (0 == var7)
                {
                    var7 = '?';
                }

                ch = var7;
            }

            sb.append((char) ch);
        }
        return sb.toString();
    }

    public byte[] readBytes() {
        int i = currentPosition;
        while (payload[currentPosition++] != 10)
            ;
        byte abyte0[] = new byte[currentPosition - i - 1];
        System.arraycopy(payload, i, abyte0, i - i, currentPosition - 1 - i);
        return abyte0;
    }

    public void readBytes(int length, int offset, byte abyte0[]) {
        for (int l = offset; l < offset + length; l++)
            abyte0[l] = payload[currentPosition++];
    }

    public void initBitAccess() {
        bitPosition = currentPosition * 8;
    }

    public int readBits(int i) {
        int k = bitPosition >> 3;
        int l = 8 - (bitPosition & 7);
        int i1 = 0;
        bitPosition += i;
        for (; i > l; l = 8) {
            i1 += (payload[k++] & anIntArray1409[l]) << i - l;
            i -= l;
        }
        if (i == l)
            i1 += payload[k] & anIntArray1409[l];
        else
            i1 += payload[k] >> l - i & anIntArray1409[i];
        return i1;
    }

    public void finishBitAccess() {
        currentPosition = (bitPosition + 7) / 8;
    }

    public int method421() {
        try {
            int i = payload[currentPosition] & 0xff;
            if (i < 128)
                return readUnsignedByte() - 64;
            else
                return readUShort() - 49152;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void doKeys() {
        int i = currentPosition;
        currentPosition = 0;
        byte abyte0[] = new byte[i];
        readBytes(i, 0, abyte0);
        BigInteger biginteger2 = new BigInteger(abyte0);
        BigInteger biginteger3 = biginteger2.modPow(RSA_EXPONENT, RSA_MODULUS);
        byte abyte1[] = biginteger3.toByteArray();
        currentPosition = 0;
        writeUnsignedByte(abyte1.length);
        writeBytes(abyte1, abyte1.length, 0);
    }

    public void method424(int i) {
        payload[currentPosition++] = (byte) (-i);
    }

    public void method425(int j) {
        payload[currentPosition++] = (byte) (128 - j);
    }

    public int method426() {
        return payload[currentPosition++] - 128 & 0xff;
    }

    public int method427() {
        return -payload[currentPosition++] & 0xff;
    }

    public int method428() {
        return 128 - payload[currentPosition++] & 0xff;
    }

    public byte method429() {
        return (byte) (-payload[currentPosition++]);
    }

    public byte method430() {
        return (byte) (128 - payload[currentPosition++]);
    }

    public void method431(int i) {
        payload[currentPosition++] = (byte) i;
        payload[currentPosition++] = (byte) (i >> 8);
    }

    public void method432(int j) {
        payload[currentPosition++] = (byte) (j >> 8);
        payload[currentPosition++] = (byte) (j + 128);
    }

    public void method433(int j) {
        payload[currentPosition++] = (byte) (j + 128);
        payload[currentPosition++] = (byte) (j >> 8);
    }

    public int method434() {
        currentPosition += 2;
        return ((payload[currentPosition - 1] & 0xff) << 8)
                + (payload[currentPosition - 2] & 0xff);
    }

    public int readUShortA() {
        currentPosition += 2;
        return ((payload[currentPosition - 2] & 0xff) << 8)
                + (payload[currentPosition - 1] - 128 & 0xff);
    }

    public int method436() {
        currentPosition += 2;
        return ((payload[currentPosition - 1] & 0xff) << 8)
                + (payload[currentPosition - 2] - 128 & 0xff);
    }

    public int method437() {
        currentPosition += 2;
        int j = ((payload[currentPosition - 1] & 0xff) << 8)
                + (payload[currentPosition - 2] & 0xff);
        if (j > 32767)
            j -= 0x10000;
        return j;
    }

    public int method438() {
        currentPosition += 2;
        int j = ((payload[currentPosition - 1] & 0xff) << 8)
                + (payload[currentPosition - 2] - 128 & 0xff);
        if (j > 32767)
            j -= 0x10000;
        return j;
    }

    public int method439() {
        currentPosition += 4;
        return ((payload[currentPosition - 2] & 0xff) << 24)
                + ((payload[currentPosition - 1] & 0xff) << 16)
                + ((payload[currentPosition - 4] & 0xff) << 8)
                + (payload[currentPosition - 3] & 0xff);
    }

    public int method440() {
        currentPosition += 4;
        return ((payload[currentPosition - 3] & 0xff) << 24)
                + ((payload[currentPosition - 4] & 0xff) << 16)
                + ((payload[currentPosition - 1] & 0xff) << 8)
                + (payload[currentPosition - 2] & 0xff);
    }
    public int readUnsignedIntSmartShortCompat() {
        int var1 = 0;

        int var2;
        for (var2 = this.readUSmart(); var2 == 32767; var2 = this.readUSmart()) {
            var1 += 32767;
        }

        var1 += var2;
        return var1;
    }

    public int readUSmart() {
        int peek = payload[currentPosition] & 0xFF;
        return peek < 128 ? this.readUnsignedByte() : this.readUShort() - 0x8000;
    }
    public int readSmart() {
        int value = payload[currentPosition] & 0xFF;
        if (value < 128) {
            return readUnsignedByte() - 64;
        } else {
            return readUShort() - 49152;
        }
    }
    public void setOffset(int var11) {
        currentPosition = var11;
    }
    public void method441(int i, byte abyte0[], int j) {
        for (int k = (i + j) - 1; k >= i; k--)
            payload[currentPosition++] = (byte) (abyte0[k] + 128);

    }

    public void method442(int i, int j, byte abyte0[]) {
        for (int k = (j + i) - 1; k >= j; k--)
            abyte0[k] = payload[currentPosition++];

    }
    public int getUIncrementalSmart() {
        int value = 0, remainder;
        for (remainder = readUSmart(); remainder == 32767; remainder = readUSmart()) {
            value += 32767;
        }
        value += remainder;
        return value;
    }
    public int getLength() {
        return payload.length;
    }

    public byte payload[];
    public int currentPosition;
    public int bitPosition;
    public static final int[] anIntArray1409 = {0, 1, 3, 7, 15, 31, 63, 127,
            255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff,
            0x3ffff, 0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff,
            0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff,
            0x7fffffff, -1};
    public ISAACRandomGen encryption;
    public static int anInt1412;
    public static final Deque nodeList = new Deque();
    public byte readByte() {
        return this.payload[++this.currentPosition - 1];
    }
    public int readInt() {
        currentPosition += 4;
        return ((payload[currentPosition - 4] & 0xff) << 24) + ((payload[currentPosition - 3] & 0xff) << 16) + ((payload[currentPosition - 2] & 0xff) << 8) + (payload[currentPosition - 1] & 0xff);
    }
}
