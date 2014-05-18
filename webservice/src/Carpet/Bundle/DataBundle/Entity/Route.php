<?php

namespace Carpet\Bundle\DataBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Route
 *
 * @ORM\Table()
 * @ORM\Entity
 */
class Route
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var float
     *
     * @ORM\Column(name="start_lat", type="float")
     */
    private $startLat;

    /**
     * @var float
     *
     * @ORM\Column(name="start_lon", type="float")
     */
    private $startLon;

    /**
     * @var float
     *
     * @ORM\Column(name="end_lat", type="float")
     */
    private $endLat;

    /**
     * @var float
     *
     * @ORM\Column(name="end_lon", type="float")
     */
    private $endLon;

    /**
     * @var string
     *
     * @ORM\Column(name="start_name", type="string", length=255)
     */
    private $startName;

    /**
     * @var string
     *
     * @ORM\Column(name="end_name", type="string", length=255)
     */
    private $endName;

    /**
     * @var integer
     *
     * @ORM\Column(name="duration", type="integer")
     */
    private $duration;

    /**
     * @var integer
     *
     * @ORM\Column(name="distance", type="integer")
     */
    private $distance;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="start", type="datetimetz")
     */
    private $start;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="end", type="datetime")
     */
    private $end;

    
    /**
     *
     * @ORM\OneToMany(targetEntity="RouteSegment", mappedBy="route")
     */
    private $segments;

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set startLat
     *
     * @param float $startLat
     * @return Route
     */
    public function setStartLat($startLat)
    {
        $this->startLat = $startLat;

        return $this;
    }

    /**
     * Get startLat
     *
     * @return float 
     */
    public function getStartLat()
    {
        return $this->startLat;
    }

    /**
     * Set startLon
     *
     * @param float $startLon
     * @return Route
     */
    public function setStartLon($startLon)
    {
        $this->startLon = $startLon;

        return $this;
    }

    /**
     * Get startLon
     *
     * @return float 
     */
    public function getStartLon()
    {
        return $this->startLon;
    }

    /**
     * Set endLat
     *
     * @param float $endLat
     * @return Route
     */
    public function setEndLat($endLat)
    {
        $this->endLat = $endLat;

        return $this;
    }

    /**
     * Get endLat
     *
     * @return float 
     */
    public function getEndLat()
    {
        return $this->endLat;
    }

    /**
     * Set endLon
     *
     * @param float $endLon
     * @return Route
     */
    public function setEndLon($endLon)
    {
        $this->endLon = $endLon;

        return $this;
    }

    /**
     * Get endLon
     *
     * @return float 
     */
    public function getEndLon()
    {
        return $this->endLon;
    }

    /**
     * Set startName
     *
     * @param string $startName
     * @return Route
     */
    public function setStartName($startName)
    {
        $this->startName = $startName;

        return $this;
    }

    /**
     * Get startName
     *
     * @return string 
     */
    public function getStartName()
    {
        return $this->startName;
    }

    /**
     * Set endName
     *
     * @param string $endName
     * @return Route
     */
    public function setEndName($endName)
    {
        $this->endName = $endName;

        return $this;
    }

    /**
     * Get endName
     *
     * @return string 
     */
    public function getEndName()
    {
        return $this->endName;
    }

    /**
     * Set duration
     *
     * @param integer $duration
     * @return Route
     */
    public function setDuration($duration)
    {
        $this->duration = $duration;

        return $this;
    }

    /**
     * Get duration
     *
     * @return integer 
     */
    public function getDuration()
    {
        return $this->duration;
    }

    /**
     * Set distance
     *
     * @param integer $distance
     * @return Route
     */
    public function setDistance($distance)
    {
        $this->distance = $distance;

        return $this;
    }

    /**
     * Get distance
     *
     * @return integer 
     */
    public function getDistance()
    {
        return $this->distance;
    }

    /**
     * Set start
     *
     * @param \DateTime $start
     * @return Route
     */
    public function setStart($start)
    {
        $this->start = $start;

        return $this;
    }

    /**
     * Get start
     *
     * @return \DateTime 
     */
    public function getStart()
    {
        return $this->start;
    }

    /**
     * Set end
     *
     * @param \DateTime $end
     * @return Route
     */
    public function setEnd($end)
    {
        $this->end = $end;

        return $this;
    }

    /**
     * Get end
     *
     * @return \DateTime 
     */
    public function getEnd()
    {
        return $this->end;
    }
    /**
     * Constructor
     */
    public function __construct()
    {
        $this->segments = new \Doctrine\Common\Collections\ArrayCollection();
    }

    /**
     * Add segments
     *
     * @param \Carpet\Bundle\DataBundle\Entity\RouteSegment $segments
     * @return Route
     */
    public function addSegment(\Carpet\Bundle\DataBundle\Entity\RouteSegment $segments)
    {
        $this->segments[] = $segments;

        return $this;
    }

    /**
     * Remove segments
     *
     * @param \Carpet\Bundle\DataBundle\Entity\RouteSegment $segments
     */
    public function removeSegment(\Carpet\Bundle\DataBundle\Entity\RouteSegment $segments)
    {
        $this->segments->removeElement($segments);
    }

    /**
     * Get segments
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getSegments()
    {
        return $this->segments;
    }
}
