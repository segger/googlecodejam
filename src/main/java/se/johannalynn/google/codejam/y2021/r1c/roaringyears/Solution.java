package se.johannalynn.google.codejam.y2021.r1c.roaringyears;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final boolean debug = true;

    public static final HashSet<Long> roaringYears = new HashSet(Arrays.asList(
559560L, 259260L, 859860L, 918919L, 318319L, 618619L, 722723L, 1213L, 122123L, 963964L, 123456L, 422423L, 663664L, 252627L, 363364L, 3637L, 997998L, 456457L, 560561L, 397398L, 9192L, 503504L, 444445L, 985986L, 385386L, 700701L, 537538L, 641642L, 100101L, 478479L, 582583L, 899091L, 434435L, 111213L, 134135L, 375376L, 825826L, 525526L, 766767L, 270271L, 466467L, 2324L, 1234L, 215216L, 515516L, 860861L, 959697L, 4748L, 156157L, 606607L, 908909L, 547548L, 110111L, 412413L, 1011L, 353354L, 488489L, 803804L, 294295L, 744745L, 849850L, 685686L, 941942L, 237238L, 882883L, 178179L, 328329L, 732733L, 132133L, 432433L, 827828L, 527528L, 631632L, 931932L, 227228L, 709710L, 525354L, 272273L, 569570L, 3435L, 2345L, 869870L, 777879L, 754755L, 454455L, 5859L, 868788L, 727374L, 154155L, 410411L, 306307L, 112113L, 847848L, 2122L, 653654L, 892893L, 292293L, 188189L, 805806L, 205206L, 250251L, 687688L, 791792L, 880881L, 776777L, 176177L, 549550L, 675676L, 6970L, 975976L, 870871L, 166167L, 570571L, 616617L, 316317L, 3456L, 665666L, 498499L, 365366L, 4546L, 198199L, 815816L, 161718L, 260261L, 710711L, 697698L, 953954L, 3233L, 3456789L, 592593L, 505506L, 338339L, 144145L, 400401L, 837838L, 387388L, 643644L, 476477L, 249250L, 282283L, 757677L, 736737L, 840841L, 136137L, 240241L, 977978L, 377378L, 545556L, 181182L, 523524L, 464465L, 707172L, 4567L, 817818L, 921922L, 5657L, 621622L, 758759L, 862863L, 217218L, 419420L, 158159L, 262263L, 579580L, 4344L, 545546L, 955956L, 355356L, 486487L, 590591L, 239240L, 896897L, 839840L, 296297L, 638639L, 848586L, 683684L, 636465L, 943944L, 454647L, 884885L, 284285L, 326327L, 671672L, 616263L, 933934L, 404142L, 874875L, 420421L, 661662L, 124125L, 965966L, 798799L, 5678L, 6768L, 229230L, 407408L, 348349L, 693694L, 304305L, 714715L, 5455L, 3031L, 899900L, 911912L, 501502L, 852853L, 207208L, 442443L, 987988L, 148149L, 102103L, 141516L, 580581L, 390391L, 628629L, 673674L, 313233L, 768769L, 409410L, 872873L, 168169L, 314315L, 830831L, 126127L, 230231L, 967968L, 678L, 367368L, 496497L, 7879L, 513514L, 6789L, 389390L, 695696L, 429430L, 989990L, 4142L, 608609L, 712713L, 6566L, 788789L, 336337L, 440441L, 746747L, 850851L, 146147L, 191192L, 474475L, 104105L, 939495L, 430431L, 734735L, 8990L, 567568L, 219220L, 373839L, 686970L, 462463L, 274275L, 724725L, 557558L, 456L, 499500L, 829830L, 923924L, 379380L, 452453L, 756757L, 5253L, 7677L, 651652L, 484485L, 114115L, 357358L, 894895L, 807808L, 299300L, 252253L, 589590L, 702703L, 945946L, 535536L, 778779L, 192021L, 232425L, 865866L, 935936L, 838485L, 335336L, 576577L, 980981L, 234L, 276277L, 405406L, 646647L, 105106L, 450451L, 150151L, 887888L, 691692L, 6364L, 8788L, 843844L, 209210L, 716717L, 220221L, 131415L, 184185L, 761762L, 598599L, 913914L, 139140L, 313314L, 254255L, 831832L, 127128L, 795796L, 668669L, 172173L, 288289L, 588589L, 738739L, 301302L, 542543L, 242243L, 417418L, 658659L, 162163L, 358359L, 612613L, 808809L, 979980L, 728729L, 282930L, 494495L, 194195L, 232233L, 323324L, 391392L, 7475L, 264265L, 566567L, 9899L, 888990L, 520521L, 957958L, 636637L, 5051L, 1920L, 140141L, 439440L, 509510L, 706707L, 210211L, 505152L, 472473L, 345346L, 323334L, 990991L, 286287L, 903904L, 244245L, 415416L, 544545L, 785786L, 460461L, 160161L, 897898L, 606162L, 726727L, 771772L, 925926L, 900901L, 970971L, 8586L, 600601L, 393394L, 564565L, 266267L, 437438L, 482483L, 522523L, 6162L, 381382L, 787980L, 363738L, 704705L, 510511L, 947948L, 622623L, 586587L, 992993L, 959960L, 969970L, 149150L, 371372L, 449450L, 821822L, 117118L, 500501L, 200201L, 333334L, 937938L, 853854L, 532533L, 459460L, 474849L, 555657L, 1718L, 648649L, 9697L, 182183L, 222223L, 7273L, 298299L, 875876L, 915916L, 681682L, 748749L, 311312L, 554555L, 797798L, 427428L, 12345L, 540541L, 781782L, 823824L, 969798L, 164165L, 447448L, 688689L, 492493L, 234235L, 2829L, 919293L, 775776L, 119120L, 517518L, 394041L, 321322L, 731732L, 604605L, 424344L, 801802L, 8384L, 599600L, 142143L, 425426L, 470471L, 708709L, 343344L, 753754L, 212213L, 626627L, 905906L, 291292L, 741742L, 574575L, 982983L, 278279L, 857858L, 361362L, 811812L, 107108L, 644645L, 212223L, 1516L, 927928L, 480481L, 879880L, 890891L, 7071L, 186187L, 763764L, 539540L, 596597L, 9495L, 949950L, 129130L, 960961L, 550551L, 793794L, 383384L, 256257L, 833834L, 469470L, 666667L, 3940L, 457458L, 373374L, 656657L, 109110L, 479480L, 331332L, 572573L, 202203L, 984985L, 614615L, 855856L, 737475L, 530531L, 196197L, 813814L, 939940L, 2627L, 351352L, 8182L, 224225L, 594595L, 634635L, 507508L, 877878L, 917918L, 552553L, 818283L, 962963L, 258259L, 835836L, 575859L, 130131L, 867868L, 181920L, 950951L, 783784L, 413414L, 519520L, 246247L, 889890L, 3738L, 1314L, 490491L, 120121L, 940941L, 773774L, 403404L, 199200L, 529530L, 236237L, 343536L, 152153L, 562563L, 602603L, 395396L, 435436L, 972973L, 268269L, 308309L, 845846L, 678679L, 718719L, 9293L, 656667L, 262728L, 341342L, 214215L, 174175L, 751752L, 994995L, 584585L, 624625L, 676869L, 607608L, 907908L, 307308L, 411412L, 711712L, 548549L, 111112L, 848849L, 952953L, 248249L, 352353L, 626364L, 652653L, 929930L, 893894L, 293294L, 593594L, 4849L, 2425L, 189190L, 789790L, 489490L, 585960L, 974975L, 433434L, 374375L, 630631L, 526527L, 467468L, 571572L, 56789L, 329330L, 514515L, 455456L, 396397L, 456789L, 696697L, 535455L, 5960L, 504505L, 204205L, 445446L, 3536L, 145146L, 386387L, 790791L, 1112L, 836837L, 536537L, 777778L, 340341L, 477478L, 281282L, 733734L, 674675L, 919920L, 930931L, 871872L, 226227L, 858687L, 167168L, 617618L, 121122L, 558559L, 9091L, 423424L, 717273L, 364365L, 814815L, 755756L, 698699L, 261262L, 398399L, 339340L, 743744L, 443444L, 143144L, 2223L, 401402L, 538539L, 101102L, 838839L, 942943L, 238239L, 642643L, 4647L, 283284L, 676677L, 780781L, 765766L, 165166L, 317318L, 421422L, 123124L, 858859L, 664665L, 101112L, 816817L, 920921L, 216217L, 155156L, 996997L, 605606L, 798081L, 305306L, 654655L, 891892L, 354355L, 487488L, 187188L, 804805L, 293031L, 986987L, 686687L, 909910L, 3334L, 303132L, 881882L, 581582L, 5758L, 177178L, 327328L, 133134L, 376377L, 808182L, 349350L, 826827L, 2021L, 632633L, 465466L, 949596L, 271272L, 444546L, 721722L, 964965L, 516517L, 694695L, 806807L, 910911L, 610611L, 747748L, 851852L, 206207L, 147148L, 988989L, 251252L, 534535L, 388389L, 4445L, 192193L, 475476L, 6869L, 285286L, 627628L, 568569L, 672673L, 169170L, 3132L, 649650L, 828829L, 932933L, 23456L, 228229L, 873874L, 273274L, 556557L, 660661L, 966967L, 366367L, 497498L, 769770L, 863864L, 7980L, 113114L, 650651L, 954955L, 787788L, 591592L, 895896L, 337338L, 242526L, 34567L, 609610L, 682683L, 159160L, 703704L, 944945L, 5556L, 885886L, 431432L, 841842L, 137138L, 4243L, 976977L, 315316L, 383940L, 725726L, 789L, 170171L, 512513L, 620621L, 922923L, 218219L, 453454L, 998999L, 303304L, 699700L, 45678L, 157158L, 495051L, 115116L, 179180L, 956957L, 356357L, 779780L, 485486L, 502503L, 684685L, 701702L, 6667L, 639640L, 883884L, 325326L, 735736L, 619620L, 978979L, 5354L, 135136L, 180181L, 378379L, 418419L, 463464L, 151617L, 723724L, 567L, 347348L, 451452L, 757758L, 861862L, 263264L, 713714L, 546547L, 767778L, 441442L, 295296L, 912913L, 208209L, 745746L, 578579L, 190191L, 7778L, 103104L, 640641L, 473474L, 4041L, 6465L, 241242L, 524525L, 934935L, 767768L, 345L, 125126L, 629630L, 662663L, 495496L, 368369L, 408409L, 818819L, 324325L, 565566L, 464748L, 265266L, 635636L, 876877L, 680681L, 380381L, 705706L, 8889L, 946947L, 346347L, 750751L, 587588L, 991992L, 12L, 5152L, 902903L, 302303L, 7576L, 243244L, 820821L, 116117L, 784785L, 657658L, 161162L, 123L, 854855L, 596061L, 727728L, 739740L, 195196L, 772773L, 809810L, 231232L, 924925L, 901902L, 601602L, 23L, 749750L, 717718L, 221222L, 483484L, 819820L, 183184L, 747576L, 369370L, 669670L, 312313L, 679680L, 929394L, 553554L, 253254L, 428429L, 799800L, 173174L, 623624L, 6263L, 34L, 646566L, 8687L, 461462L, 898899L, 334335L, 577578L, 275276L, 968969L, 531532L, 404405L, 647648L, 151152L, 1234567L, 45L, 715716L, 760761L, 597598L, 297298L, 914915L, 426427L, 555556L, 796797L, 255256L, 1819L, 171172L, 471472L, 7374L, 56L, 272829L, 370371L, 9798L, 222324L, 936937L, 611612L, 575576L, 981982L, 277278L, 448449L, 493494L, 533534L, 406407L, 359360L, 392393L, 67L, 692693L, 842843L, 438439L, 138139L, 958959L, 521522L, 637638L, 382383L, 832833L, 759760L, 128129L, 211212L, 948949L, 511512L, 344345L, 345678L, 287288L, 904905L, 78L, 864865L, 670671L, 737738L, 8485L, 300301L, 543544L, 416417L, 786787L, 6061L, 2930L, 360361L, 193194L, 233234L, 770771L, 810811L, 106107L, 234567L, 979899L, 414243L, 886887L, 659660L, 322323L, 926927L, 89L, 153154L, 394395L, 436437L, 677678L, 481482L, 764765L, 223224L, 171819L, 333435L, 506507L, 310311L, 719720L, 121314L, 551552L, 792793L, 834835L, 1617L, 175176L, 2345678L, 131132L, 9596L, 414415L, 7172L, 201202L, 332333L, 742743L, 615616L, 878889L, 402403L, 812813L, 666768L, 108109L, 730731L, 563564L, 971972L, 267268L, 846847L, 350351L, 800801L, 633634L, 309310L, 720721L, 916917L, 828384L, 2728L, 752753L, 993994L, 585586L, 458459L, 995996L, 353637L, 868869L, 372373L, 565758L, 245246L, 782783L, 822823L, 655656L, 528529L, 118119L, 938939L, 8283L, 491492L, 197198L, 774775L, 561562L, 973974L, 603604L, 399400L, 844845L, 185186L, 802803L, 484950L, 468469L, 1415L, 3839L, 269270L, 384385L, 667668L, 342343L, 583584L, 213214L, 625626L, 866867L, 434445L, 906907L, 541542L, 951952L, 247248L, 824825L, 515253L, 9394L, 289290L, 362363L, 235236L, 645646L, 518519L, 690691L, 928929L, 280281L, 320321L, 888889L, 225226L, 762763L, 909192L, 595596L, 508509L, 2526L, 141142L, 878879L, 424425L, 697071L, 961962L, 257258L, 794795L, 707708L, 279280L, 319320L, 689690L, 729730L, 8081L, 740741L, 290291L, 330331L, 573574L, 163164L, 203204L, 983984L, 613614L, 856857L, 202122L, 446447L, 4950L
            ));

    public static void main(String[] args) {
        if (debug) {
            String data = "4\n" +
                    "2020\n" +
                    "2021\n" +
                    "68000\n" +
                    "101\n";
            InputStream stdin = System.in;
            try {
                System.setIn(new ByteArrayInputStream(data.getBytes()));
                run(args);
            } finally {
                System.setIn(stdin);
            }
        } else {
            run(args);
        }
    }

    public static void run(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            String year = in.nextLine();
            System.out.println("Case #" + i + ": " + result(year));
        }
    }

    private static String result(String year) {
        long currentYear = Long.parseLong(year);
        long c = 0;
        while(c < 100000L) {
            currentYear += 1;
            if(roaringYears.contains(currentYear)) {
                return String.valueOf(currentYear);
            }
            c++;
        }
        return "Something went wrong";
    }

}