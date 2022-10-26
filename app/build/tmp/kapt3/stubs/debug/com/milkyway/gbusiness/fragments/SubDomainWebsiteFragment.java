package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [SubDomainWebsiteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00c8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b1\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010u\u001a\u00020vH\u0002J\b\u0010w\u001a\u00020vH\u0002J\u0018\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00172\u0006\u0010{\u001a\u00020?H\u0002J2\u0010|\u001a\u00020v2\u0006\u0010}\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020\u00172\u0006\u0010\u007f\u001a\u00020\u00172\u0007\u0010\u0080\u0001\u001a\u00020\u00172\u0007\u0010\u0081\u0001\u001a\u00020\u0017H\u0002J\t\u0010\u0082\u0001\u001a\u00020vH\u0002J\u0011\u0010\u0083\u0001\u001a\u00020v2\u0006\u0010\f\u001a\u00020\rH\u0002J\t\u0010\u0084\u0001\u001a\u00020vH\u0002J\u0011\u0010\u0085\u0001\u001a\u00020v2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0086\u0001\u001a\u00020v2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010AH\u0002J\u0012\u0010\u0088\u0001\u001a\u00020v2\u0007\u0010\u0089\u0001\u001a\u00020,H\u0002J\u0019\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0017H\u0002J\u001a\u0010\u008d\u0001\u001a\u00020\u00172\u000f\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u0090\u00010\u008f\u0001H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020v2\u0007\u0010\u0089\u0001\u001a\u00020,H\u0002J)\u0010\u0092\u0001\u001a\u00020y2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0011\u0010\u0093\u0001\u001a\u00020v2\u0006\u0010{\u001a\u00020?H\u0016J\u0014\u0010\u0094\u0001\u001a\u00020v2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\rH\u0016J,\u0010\u0096\u0001\u001a\u0004\u0018\u00010,2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\rH\u0016J7\u0010\u009b\u0001\u001a\u00020v2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0018\u0010\u00a0\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u00170\u0011j\t\u0012\u0004\u0012\u00020\u0017`\u00a1\u0001H\u0016J\u001c\u0010\u00a2\u0001\u001a\u00020v2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u0012H\u0016J7\u0010\u00a3\u0001\u001a\u00020v2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0018\u0010\u00a0\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u00170\u0011j\t\u0012\u0004\u0012\u00020\u0017`\u00a1\u0001H\u0016J\u001c\u0010\u00a6\u0001\u001a\u00020v2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u00a4\u0001\u001a\u00020ZH\u0016J\u001c\u0010\u00a7\u0001\u001a\u00020v2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u00a4\u0001\u001a\u00020aH\u0016J\t\u0010\u00a8\u0001\u001a\u00020vH\u0002J\u0013\u0010\u00a9\u0001\u001a\u00020v2\b\u0010\u00aa\u0001\u001a\u00030\u00ab\u0001H\u0002J\u0012\u0010\u00ac\u0001\u001a\u00020v2\u0007\u0010\u0089\u0001\u001a\u00020,H\u0002J\u00c6\u0001\u0010\u00ad\u0001\u001a\u00020v2\u0007\u0010\u00ae\u0001\u001a\u00020\u00172\u0007\u0010\u00af\u0001\u001a\u00020\u00172\u0007\u0010\u00b0\u0001\u001a\u00020\u00172\u0007\u0010\u00b1\u0001\u001a\u00020\u00172\u0007\u0010\u00b2\u0001\u001a\u00020\u00172\u0007\u0010\u00b3\u0001\u001a\u00020\u00172\u0007\u0010\u00b4\u0001\u001a\u00020\u00172\u0007\u0010\u00b5\u0001\u001a\u00020\u00172\u0007\u0010\u00b6\u0001\u001a\u00020\u00172\u0007\u0010\u00b7\u0001\u001a\u00020\u00172\u0007\u0010\u00b8\u0001\u001a\u00020\u00172\u0007\u0010\u00b9\u0001\u001a\u00020\u00172\u0007\u0010\u00ba\u0001\u001a\u00020\u00172\u0007\u0010\u00bb\u0001\u001a\u00020\u00172\u0007\u0010\u00bc\u0001\u001a\u00020\u00172\u0007\u0010\u00bd\u0001\u001a\u00020\u00172\u0007\u0010\u00be\u0001\u001a\u00020\u00172\u0007\u0010\u00bf\u0001\u001a\u00020\u00172\u0007\u0010\u00c0\u0001\u001a\u00020\u00172\u0007\u0010\u00c1\u0001\u001a\u00020\u00172\u0007\u0010\u00c2\u0001\u001a\u00020\u0017H\u0002J\u0011\u0010\u00c3\u0001\u001a\u00020v2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u00c4\u0001\u001a\u00020v2\u0007\u0010\u009e\u0001\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u00c5\u0001\u001a\u00020v2\u000f\u0010\u00a4\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a5\u00010\u008f\u0001H\u0002J\t\u0010\u00c6\u0001\u001a\u00020vH\u0002J\u001a\u0010\u00c7\u0001\u001a\u00020v2\u000f\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u0090\u00010\u008f\u0001H\u0002J\t\u0010\u00c8\u0001\u001a\u00020vH\u0002J-\u0010\u00c9\u0001\u001a\u00020v2\u0007\u0010\u00ca\u0001\u001a\u00020\u00172\u0007\u0010\u00cb\u0001\u001a\u00020\u00172\u0007\u0010\u00cc\u0001\u001a\u00020\u00172\u0007\u0010\u00cd\u0001\u001a\u00020\u0017H\u0002J\u0019\u0010\u00ce\u0001\u001a\u00020v2\u0006\u0010@\u001a\u00020A2\u0006\u0010j\u001a\u00020gH\u0002J\u001a\u0010\u00cf\u0001\u001a\u00020v2\u0007\u0010\u00d0\u0001\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002J\t\u0010\u00d1\u0001\u001a\u00020vH\u0002J\t\u0010\u00d2\u0001\u001a\u00020vH\u0002J\u001a\u0010\u00d3\u0001\u001a\u00020v2\u0007\u0010\u00d4\u0001\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0012\u0010\u00d5\u0001\u001a\u00020v2\u0007\u0010\u00d6\u0001\u001a\u00020\u0017H\u0002J\u001a\u0010\u00d7\u0001\u001a\u00020v2\u0007\u0010\u00d0\u0001\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002J\u001a\u0010\u00d8\u0001\u001a\u00020v2\u0007\u0010\u00d0\u0001\u001a\u00020\u00172\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0012\u0010\u00d9\u0001\u001a\u00020\u00172\u0007\u0010\u00da\u0001\u001a\u00020\u0017H\u0002J\t\u0010\u00db\u0001\u001a\u00020yH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020GX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020GX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010RX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020RX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020RX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020RX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010RX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010RX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020gX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00dc\u0001"}, d2 = {"Lcom/milkyway/gbusiness/fragments/SubDomainWebsiteFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/PaymentGatewayAdaptor$PaymentGatewayAdaptorClick;", "Lcom/milkyway/gbusiness/adaptor/SocialMediaAdaptor$SocialMediaAdaptorClick;", "Lcom/milkyway/gbusiness/adaptor/SellerLinksAdaptor$SellerLinksAdaptorClick;", "Lcom/milkyway/gbusiness/adaptor/BusinessGalleryAdaptor$OnGalleryAdaptorClick;", "Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$OnBusinessServiceAdaptorClick;", "()V", "addRatingResponse", "Lcom/milkyway/gbusiness/models/AddReviewsDataClass;", "addRatingValue", "", "args", "Landroid/os/Bundle;", "bServiceAdapter", "Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor;", "bServiceList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/BusinessServiceModelClass$Data;", "btnSubmitQuery", "Landroid/widget/Button;", "btnSubmitReview", "businessId", "", "businessName", "businessPhone", "etCommentReview", "Landroid/widget/EditText;", "etEmailReview", "etMobileReview", "etNameReview", "etQuery", "getData", "Lcom/milkyway/gbusiness/models/GalleryResponseDataClass;", "getPaymentData", "Lcom/milkyway/gbusiness/models/BusinessPaymentDataClass;", "getReviewsResponse", "Lcom/milkyway/gbusiness/models/GetReviewsDataClass;", "hrsList", "Lcom/milkyway/gbusiness/models/BusinessHrsDataClass$HrsData;", "ivBannerSubdomain", "Landroid/widget/ImageView;", "ivNoGallery", "layoutAboutUs", "Landroid/view/View;", "layoutAlsoListed", "layoutChangeCampaign", "Landroid/widget/LinearLayout;", "layoutEditThis", "layoutMail", "layoutMap", "layoutReview", "layoutSellerLinks", "layoutSocialMedia", "layoutView", "layoutWhatsapp", "layoutWorkingHrs", "layoutWriteReview", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "mScreenshotImageUri", "Landroid/net/Uri;", "mView", "notAvailable", "payQRCodeList", "Lcom/milkyway/gbusiness/models/PaymentGatewayData;", "ratingBar", "Landroid/widget/RatingBar;", "ratingBarReview", "ratingBarReviewDlg", "rbAboutUs", "Lcom/milkyway/gbusiness/utils/MyRadioButton;", "rbAlsoListed", "rbReview", "rbSellerLink", "rbSocialMedia", "rbWorkingHrs", "rvBusinessHrs", "Landroidx/recyclerview/widget/RecyclerView;", "rvBusinessServices", "rvGalleryImages", "rvPaymentGateway", "rvReviews", "rvSellerLink", "rvSocialMedia", "sellerLinkList", "Lcom/milkyway/gbusiness/models/SellerLinkData;", "sellerLinksAdaptor", "Lcom/milkyway/gbusiness/adaptor/SellerLinksAdaptor;", "shareBusinessListText", "socialMediaAdaptor", "Lcom/milkyway/gbusiness/adaptor/SocialMediaAdaptor;", "socialMediaList", "Lcom/milkyway/gbusiness/models/SocialMediaData;", "subDomainUrl", "subdomainWebSiteBack", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "tvAvgRatingValue", "Landroid/widget/TextView;", "tvBusinessEstablishedDate", "tvDescription", "tvFileName", "tvLocation", "tvLocationAboutUs", "tvMobile", "tvMobileAboutUs", "tvQrNotFound", "tvTitleBusiness", "tvTitleBusinessAboutUs", "tvVotesValue", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "alertRatingReviewDialog", "", "alertShareBusinessDialog", "appInstalledOrNot", "", "packageName", "context", "callAddRatingApi", "ratingVal", "name", "email", "phone", "comment", "callBServiceAdapter", "callGalleryApi", "callGetReviewsApi", "callPaymentMethodApi", "callWantToSaySomethingApi", "fileUri", "clickListener", "view", "getArrayOfUrls", "", "str", "getAverageRatingValue", "reviewList", "", "Lcom/milkyway/gbusiness/models/GetReviewsDataClass$Data;", "initializeView", "isValidate", "onAttach", "onCreate", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onGalleryItemClicked", "position", "", "data", "Lcom/milkyway/gbusiness/models/GalleryModelData$Data;", "uriString", "Lkotlin/collections/ArrayList;", "onItemClicked", "onPayQrItemClicked", "list", "Lcom/milkyway/gbusiness/models/BusinessPaymentDataClass$Data;", "onSellerLinkItemClicked", "onSocialItemClicked", "openWhatsApp", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickScreenShot", "setBusinessHrsAdapter", "sunday", "sundayStart", "sundayEnd", "monday", "mondayStart", "mondayEnd", "tuesday", "tuesdayStart", "tuesdayEnd", "wednesday", "wednesdayStart", "wednesdayEnd", "thirsday", "thirsdayStart", "thirsdayEnd", "friday", "fridayStart", "fridayEnd", "saturday", "saturdayStart", "saturdayEnd", "setData", "setGalleryAdapter", "setPaymentDataAdapter", "setRadioListeners", "setReviewsAdapter", "setSellerLinksAdapter", "setSocialMediaAdapter", "facebookUrl", "linkedinUrl", "twitterUrl", "instagramUrl", "setUploadStr", "shareBusinessListByFacebook", "packageString", "shareBusinessListByInstagram", "shareBusinessListByLinkedin", "shareBusinessListBySms", "defaultSmsPackageName", "shareBusinessListByTwitter", "message", "shareBusinessListByWhatsapp", "shareIntent", "urlEncode", "s", "validateWantToSay", "app_debug"})
public final class SubDomainWebsiteFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.PaymentGatewayAdaptor.PaymentGatewayAdaptorClick, com.milkyway.gbusiness.adaptor.SocialMediaAdaptor.SocialMediaAdaptorClick, com.milkyway.gbusiness.adaptor.SellerLinksAdaptor.SellerLinksAdaptorClick, com.milkyway.gbusiness.adaptor.BusinessGalleryAdaptor.OnGalleryAdaptorClick, com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.OnBusinessServiceAdaptorClick {
    private android.content.Context mContext;
    private android.os.Bundle args;
    private android.widget.ImageView subdomainWebSiteBack;
    private android.widget.ImageView ivNoGallery;
    private androidx.recyclerview.widget.RecyclerView rvPaymentGateway;
    private androidx.recyclerview.widget.RecyclerView rvReviews;
    private androidx.recyclerview.widget.RecyclerView rvBusinessHrs;
    private androidx.recyclerview.widget.RecyclerView rvGalleryImages;
    private final java.util.ArrayList<com.milkyway.gbusiness.models.PaymentGatewayData> payQRCodeList = null;
    private final java.util.ArrayList<com.milkyway.gbusiness.models.BusinessHrsDataClass.HrsData> hrsList = null;
    private androidx.viewpager2.widget.ViewPager2 viewPager2;
    private com.google.android.material.tabs.TabLayout tabLayout;
    private android.widget.LinearLayout layoutView;
    private android.widget.LinearLayout layoutMap;
    private android.widget.LinearLayout layoutMail;
    private android.widget.LinearLayout layoutWriteReview;
    private android.widget.LinearLayout layoutEditThis;
    private android.widget.LinearLayout layoutChangeCampaign;
    private android.widget.LinearLayout layoutWhatsapp;
    private com.milkyway.gbusiness.utils.MyRadioButton rbAboutUs;
    private com.milkyway.gbusiness.utils.MyRadioButton rbAlsoListed;
    private com.milkyway.gbusiness.utils.MyRadioButton rbWorkingHrs;
    private com.milkyway.gbusiness.utils.MyRadioButton rbSocialMedia;
    private com.milkyway.gbusiness.utils.MyRadioButton rbSellerLink;
    private com.milkyway.gbusiness.utils.MyRadioButton rbReview;
    private android.view.View layoutAboutUs;
    private android.view.View layoutAlsoListed;
    private android.view.View layoutWorkingHrs;
    private android.view.View layoutSocialMedia;
    private android.view.View layoutSellerLinks;
    private android.view.View layoutReview;
    private android.view.View mView;
    private android.widget.TextView tvTitleBusiness;
    private android.widget.ImageView ivBannerSubdomain;
    private android.widget.TextView tvQrNotFound;
    private android.widget.TextView tvTitleBusinessAboutUs;
    private android.widget.TextView tvDescription;
    private android.widget.TextView tvAvgRatingValue;
    private android.widget.TextView tvVotesValue;
    private android.widget.TextView tvLocation;
    private android.widget.TextView tvLocationAboutUs;
    private android.widget.TextView tvMobile;
    private android.widget.TextView tvMobileAboutUs;
    private android.widget.TextView tvBusinessEstablishedDate;
    private android.widget.EditText etNameReview;
    private android.widget.EditText etEmailReview;
    private android.widget.EditText etMobileReview;
    private android.widget.EditText etCommentReview;
    private android.widget.RatingBar ratingBar;
    private java.lang.String businessName;
    private java.lang.String businessId;
    private java.lang.String businessPhone;
    private java.lang.String subDomainUrl;
    private android.widget.RatingBar ratingBarReview;
    private android.widget.Button btnSubmitReview;
    private float addRatingValue = 0.0F;
    private com.milkyway.gbusiness.models.AddReviewsDataClass addRatingResponse;
    private com.milkyway.gbusiness.models.GalleryResponseDataClass getData;
    private com.milkyway.gbusiness.models.GetReviewsDataClass getReviewsResponse;
    private com.milkyway.gbusiness.models.BusinessPaymentDataClass getPaymentData;
    private androidx.recyclerview.widget.RecyclerView rvSocialMedia;
    private com.milkyway.gbusiness.adaptor.SocialMediaAdaptor socialMediaAdaptor;
    private java.util.ArrayList<com.milkyway.gbusiness.models.SocialMediaData> socialMediaList;
    private androidx.recyclerview.widget.RecyclerView rvSellerLink;
    private androidx.recyclerview.widget.RecyclerView rvBusinessServices;
    private com.milkyway.gbusiness.adaptor.SellerLinksAdaptor sellerLinksAdaptor;
    private com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor bServiceAdapter;
    private java.util.ArrayList<com.milkyway.gbusiness.models.SellerLinkData> sellerLinkList;
    private java.util.ArrayList<com.milkyway.gbusiness.models.BusinessServiceModelClass.Data> bServiceList;
    private java.lang.String notAvailable = "Not Available";
    private java.lang.String shareBusinessListText = "";
    private android.widget.RatingBar ratingBarReviewDlg;
    private android.widget.EditText etQuery;
    private android.widget.TextView tvFileName;
    private android.widget.Button btnSubmitQuery;
    private android.net.Uri mScreenshotImageUri;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> logoImageLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public SubDomainWebsiteFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void callGetReviewsApi() {
    }
    
    private final java.lang.String getAverageRatingValue(java.util.List<com.milkyway.gbusiness.models.GetReviewsDataClass.Data> reviewList) {
        return null;
    }
    
    private final void callBServiceAdapter() {
    }
    
    private final void setBusinessHrsAdapter(java.lang.String sunday, java.lang.String sundayStart, java.lang.String sundayEnd, java.lang.String monday, java.lang.String mondayStart, java.lang.String mondayEnd, java.lang.String tuesday, java.lang.String tuesdayStart, java.lang.String tuesdayEnd, java.lang.String wednesday, java.lang.String wednesdayStart, java.lang.String wednesdayEnd, java.lang.String thirsday, java.lang.String thirsdayStart, java.lang.String thirsdayEnd, java.lang.String friday, java.lang.String fridayStart, java.lang.String fridayEnd, java.lang.String saturday, java.lang.String saturdayStart, java.lang.String saturdayEnd) {
    }
    
    private final void callGalleryApi(android.os.Bundle args) {
    }
    
    private final void callPaymentMethodApi(android.os.Bundle args) {
    }
    
    private final void setPaymentDataAdapter(java.util.List<com.milkyway.gbusiness.models.BusinessPaymentDataClass.Data> list) {
    }
    
    private final void setGalleryAdapter(com.milkyway.gbusiness.models.GalleryResponseDataClass data, android.os.Bundle args) {
    }
    
    private final java.util.List<java.lang.String> getArrayOfUrls(java.lang.String str) {
        return null;
    }
    
    private final void alertRatingReviewDialog() {
    }
    
    private final void setReviewsAdapter(java.util.List<com.milkyway.gbusiness.models.GetReviewsDataClass.Data> reviewList) {
    }
    
    private final void setSocialMediaAdapter(java.lang.String facebookUrl, java.lang.String linkedinUrl, java.lang.String twitterUrl, java.lang.String instagramUrl) {
    }
    
    private final void setData(android.os.Bundle args) {
    }
    
    private final void setSellerLinksAdapter() {
    }
    
    private final void clickListener(android.view.View view) {
    }
    
    private final boolean validateWantToSay() {
        return false;
    }
    
    private final void pickScreenShot(android.view.View view) {
    }
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void setUploadStr(android.net.Uri mScreenshotImageUri, android.widget.TextView tvFileName) {
    }
    
    private final void callAddRatingApi(float ratingVal, java.lang.String name, java.lang.String email, java.lang.String phone, java.lang.String comment) {
    }
    
    private final void callWantToSaySomethingApi(android.net.Uri fileUri) {
    }
    
    private final void setRadioListeners() {
    }
    
    private final void openWhatsApp() {
    }
    
    @java.lang.Override()
    public void onSocialItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SocialMediaData list) {
    }
    
    @java.lang.Override()
    public void onSellerLinkItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SellerLinkData list) {
    }
    
    private final boolean isValidate(android.widget.EditText etNameReview, android.widget.EditText etEmailReview, android.widget.EditText etMobileReview, android.widget.EditText etCommentReview) {
        return false;
    }
    
    private final void alertShareBusinessDialog() {
    }
    
    private final void shareBusinessListByLinkedin() {
    }
    
    private final void shareBusinessListByInstagram() {
    }
    
    private final boolean appInstalledOrNot(java.lang.String packageName, android.content.Context context) {
        return false;
    }
    
    private final void shareBusinessListByTwitter(java.lang.String message) {
    }
    
    private final java.lang.String urlEncode(java.lang.String s) {
        return null;
    }
    
    private final void shareBusinessListByFacebook(java.lang.String packageString, java.lang.String shareBusinessListText) {
    }
    
    private final void shareBusinessListByWhatsapp(java.lang.String packageString, java.lang.String shareBusinessListText) {
    }
    
    private final void shareIntent(java.lang.String packageString, java.lang.String shareBusinessListText) {
    }
    
    private final void shareBusinessListBySms(java.lang.String defaultSmsPackageName, java.lang.String shareBusinessListText) {
    }
    
    @java.lang.Override()
    public void onGalleryItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.GalleryModelData.Data data, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> uriString) {
    }
    
    @java.lang.Override()
    public void onPayQrItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessPaymentDataClass.Data list, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> uriString) {
    }
    
    @java.lang.Override()
    public void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessServiceModelClass.Data data) {
    }
}